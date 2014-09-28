package cz.dusanrychnovsky.whattoreadnext.authors;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AuthorLiteRowMapper implements RowMapper<AuthorLite> {

	@Override
	public AuthorLite mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new AuthorLite(
			rs.getInt("authorId"),
			rs.getString("firstname"),
			rs.getString("lastname")
		);
	}

}
