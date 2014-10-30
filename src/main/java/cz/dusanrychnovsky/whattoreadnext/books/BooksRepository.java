package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cz.dusanrychnovsky.whattoreadnext.Repository;
import cz.dusanrychnovsky.whattoreadnext.ratings.Opinion;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@Service
public class BooksRepository extends Repository {
	
	private final BookExtractor bookExtractor;
	
	@Autowired
	public BooksRepository(
		final JdbcTemplate jdbcTemplate, 
		final BookExtractor bookExtractor,
		final BookRowMapper bookRowMapper) {
		
		super(jdbcTemplate);
		
		this.bookExtractor = bookExtractor;
	}
	
	/**
	 * 
	 * @param criteria
	 * @return
	 */
	public Collection<Book> find(final SearchCriteria criteria) {

		SearchQueryBuilder searchQueryBuilder = new SearchQueryBuilder();
		searchQueryBuilder.clear().addKeywords(criteria.getKeywords());
		
		final String query = searchQueryBuilder.buildQuery();
		final Object[] params = searchQueryBuilder.buildParams();
		
		return getTemplate().query(query, params, bookExtractor);
	}
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException
	 */
	public Book find(final int bookId) throws BookNotFoundException {
		
		Collection<Book> books = getTemplate().query(
			"SELECT * FROM Books NATURAL JOIN Authorship WHERE bookId = ?",
			new Object[] { bookId },
			bookExtractor
		);
		
		if (books.isEmpty()) {
			throw new BookNotFoundException(bookId);
		}
		
		if (books.size() > 1) {
			throw new AssertionError(
				"Query GET BOOK BY ID returned more than one row."
			);
		}
		
		return books.iterator().next();
	}
	
	public void setOpinion(final int bookId, final Opinion opinion)
		throws BookNotFoundException {
		
		if (!bookExists(bookId)) {
			throw new BookNotFoundException(bookId);
		}
		
		getTemplate().update(
			"MERGE INTO Reviews AS R " +
			"USING (VALUES ?) AS Val(bookId) " +
			"ON (R.bookId = Val.bookId) " +
			"WHEN MATCHED THEN UPDATE SET R.opinionId = (SELECT opinionId FROM Opinions WHERE opinion = ?) " +
			"WHEN NOT MATCHED THEN INSERT (bookId, opinionId) VALUES (?, (SELECT opinionId FROM Opinions WHERE opinion = ?))",
			new Object[] { bookId, opinion.name(), bookId, opinion.name() }
		);
	}
	
	private boolean bookExists(final int bookId) {
		
		final int count = getTemplate().queryForObject(
			"SELECT COUNT(*) FROM Books WHERE bookId = ?",
			new Object[] { bookId },
			Integer.class
		);
		
		if (count > 1) {
			throw new AssertionError(
				"Find book by id returns more than one row."
			);
		}
		
		return (count != 0);
	}
}
