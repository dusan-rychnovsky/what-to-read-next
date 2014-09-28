package cz.dusanrychnovsky.whattoreadnext.books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import scala.annotation.meta.setter;
import cz.dusanrychnovsky.whattoreadnext.Repository;
import cz.dusanrychnovsky.whattoreadnext.authors.AuthorLite;
import cz.dusanrychnovsky.whattoreadnext.authors.AuthorLiteRowMapper;
import cz.dusanrychnovsky.whattoreadnext.authors.AuthorNotFoundException;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@Service
public class BooksRepository extends Repository {
	
	private final BookLiteExtractor bookLiteExtractor = new BookLiteExtractor();
	private final BookRowMapper bookRowMapper = new BookRowMapper();
	private final AuthorLiteRowMapper authorLiteRowMapper = new AuthorLiteRowMapper();
	
	private final SearchQueryBuilder searchQueryBuilder;
	
	@Autowired
	public BooksRepository(
		final JdbcTemplate jdbcTemplate, 
		final SearchQueryBuilder searchQueryBuilder) {
		
		super(jdbcTemplate);
		this.searchQueryBuilder = searchQueryBuilder;
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<BookLite> find() {
		return getTemplate().query(
			"SELECT * FROM Books NATURAL JOIN Authorship NATURAL JOIN Authors",
			bookLiteExtractor
		);
	}
	
	/**
	 * 
	 * @param criteria
	 * @return
	 */
	public Collection<BookLite> find(final SearchCriteria criteria) {

		// TODO: will this cause race conditions?
		searchQueryBuilder.clear().addKeywords(criteria.getKeywords());
		
		final String query = searchQueryBuilder.buildQuery();
		final Object[] params = searchQueryBuilder.buildParams();
		
		return getTemplate().query(query, params, bookLiteExtractor);
	}
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException 
	 */
	public Book find(int bookId) throws BookNotFoundException {
		
		Book book;
		
		try {
			book = getTemplate().queryForObject(
				"SELECT * FROM Books WHERE bookId = ?",
				new Object[] { bookId },
				bookRowMapper
			);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new BookNotFoundException(bookId);
		}
		
		Collection<AuthorLite> authors = getTemplate().query(
			"SELECT * FROM Authorship NATURAL JOIN Authors WHERE bookId = ?",
			new Object[] { bookId },
			authorLiteRowMapper
		); 
		
		book.setAuthors(authors);
		
		return book;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public int add(final BookRequest request) throws AuthorNotFoundException {
		
		// TODO: throw an AuthorNotFoundExeption in case that any of the given
		// authorIds does not correspond to a valid author
		
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		getTemplate().update(
			new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(
						"INSERT INTO Books (title, description, imageUrl) VALUES (?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS
					);
					
					ps.setString(1, request.getTitle());
					ps.setString(2, request.getDescription());
					ps.setString(3, request.getImageUrl());
					
					return ps;
				}
			},
			keyHolder
		);
		
		final Integer bookId = keyHolder.getKey().intValue();
		
		for (Integer authorId : request.getAuthorIds()) {
			getTemplate().update(
				"INSERT INTO Authorship (authorId, bookId) VALUES (?, ?)",
				new Object[] { authorId, bookId }
			);
		}
		
		return bookId;
	}
}
