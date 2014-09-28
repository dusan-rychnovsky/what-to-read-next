package cz.dusanrychnovsky.whattoreadnext.books;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Book(
			rs.getInt("bookId"),
			rs.getString("title"),
			rs.getString("description"),
			rs.getString("imageUrl")
		);
	}
}
