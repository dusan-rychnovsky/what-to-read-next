package cz.dusanrychnovsky.whattoreadnext.authors;

import cz.dusanrychnovsky.whattoreadnext.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@Service
public class AuthorsRepository extends Repository {
	
	private static final RowMapper<AuthorLite> authorLiteMapper = new RowMapper<AuthorLite>() {
		@Override
		public AuthorLite mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new AuthorLite(
				rs.getInt("authorId"),
				rs.getString("firstname"),
				rs.getString("lastname")
			);
		}
	};

	@Autowired
	public AuthorsRepository(final JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate);
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<AuthorLite> find() {
		return getTemplate().query("SELECT * FROM Authors", authorLiteMapper);
	}
	
	/**
	 * 
	 * @param author
	 * @return
	 */
	public int add(final Author author) {
		/*
		int id = newId();
		author.setId(id);
		authors.put(id, author);
		return id;
		*/
		return 1;
	}
}
