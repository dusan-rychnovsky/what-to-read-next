package cz.dusanrychnovsky.whattoreadnext.authors;

import cz.dusanrychnovsky.whattoreadnext.Repository;
import cz.dusanrychnovsky.whattoreadnext.books.BookNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorsRepository extends Repository {
	
	private final AuthorExtractor authorExtractor;

	@Autowired
	public AuthorsRepository(
		final JdbcTemplate jdbcTemplate,
		final AuthorExtractor authorExtractor) {
		
		super(jdbcTemplate);
		
		this.authorExtractor = authorExtractor;
	}

	/**
	 * 
	 * @param authorIds
	 * @return
	 */
	public List<Author> find(List<Integer> authorIds) {
		return getNamedParameterJdbcTemplate().query(
			"SELECT * FROM Authors NATURAL JOIN Authorship WHERE authorId IN (:authorIds)",			
			new MapSqlParameterSource("authorIds", authorIds),
			authorExtractor
		);
	}
}
