package cz.dusanrychnovsky.whattoreadnext.books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class BookExtractor implements ResultSetExtractor<Collection<Book>> {

	@Override
	public Collection<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {

		final Map<Integer, Book> data = new HashMap<>();
		while (rs.next()) {
			
			int bookId = rs.getInt("bookId");
			if (!data.containsKey(bookId)) {
				Book book = createBook(rs);
				data.put(bookId, book);
			}
		
			Book book = data.get(bookId);
			
			Integer authorId = rs.getInt("authorId");
			book.addAuthor(authorId);
		}
		
		return data.values();
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Book createBook(final ResultSet rs) throws SQLException {
		return new Book(
			rs.getInt("bookId"),
			rs.getString("title"),
			rs.getString("description"),
			rs.getString("imageUrl")
		);
	}
}
