package cz.dusanrychnovsky.whattoreadnext.books;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import cz.dusanrychnovsky.whattoreadnext.ratings.Opinion;

@Component
public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new Book(
			rs.getInt("bookId"),
			rs.getString("title"),
			rs.getString("description"),
			rs.getString("imageUrl")
		);

		String opinion = rs.getString("opinion");
		if (opinion != null) {
			book.setOpinion(Opinion.valueOf(opinion));
		}
		
		return book;
	}
}
