package cz.dusanrychnovsky.whattoreadnext.authors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AuthorExtractor implements ResultSetExtractor<List<Author>> {

	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException, DataAccessException {

		final Map<Integer, Author> data = new HashMap<>();
		while (rs.next()) {
			
			Integer authorId = rs.getInt("authorId");
			if (!data.containsKey(authorId)) {
				Author author = createAuthor(rs);
				data.put(authorId, author);
			}
		
			Author author = data.get(authorId);
			
			Integer bookId = rs.getInt("bookId");
			author.addBook(bookId);
		}
		
		return new ArrayList<Author>(data.values());
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Author createAuthor(final ResultSet rs) throws SQLException {
		return new Author(
			rs.getInt("authorId"),
			rs.getString("firstname"),
			rs.getString("lastname")
		);
	}
}
