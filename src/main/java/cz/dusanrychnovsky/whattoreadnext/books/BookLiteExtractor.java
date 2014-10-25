package cz.dusanrychnovsky.whattoreadnext.books;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import cz.dusanrychnovsky.whattoreadnext.authors.AuthorLite;

@Component
public class BookLiteExtractor implements ResultSetExtractor<Collection<BookLite>> {

	@Override
	public Collection<BookLite> extractData(ResultSet rs) throws SQLException, DataAccessException {

		final Map<Integer, BookLite> data = new HashMap<>();
		while (rs.next()) {
			
			int bookId = rs.getInt("bookId");
			if (!data.containsKey(bookId)) {
				BookLite bookLite = createBookLite(rs);
				data.put(bookId, bookLite);
			}
		
			BookLite bookLite = data.get(bookId);
			
			AuthorLite authorLite = createAuthorLite(rs);
			bookLite.addAuthor(authorLite);
		}
		
		return data.values();
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private AuthorLite createAuthorLite(final ResultSet rs) throws SQLException {
		return new AuthorLite(
			rs.getInt("authorId"),
			rs.getString("firstname"),
			rs.getString("lastname")
		);
	}

	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private BookLite createBookLite(final ResultSet rs) throws SQLException {
		return new BookLite(
			rs.getInt("bookId"),
			rs.getString("title"),
			rs.getString("description"),
			rs.getString("imageUrl")
		);
	}
}
