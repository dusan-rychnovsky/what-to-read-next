package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Books {

	private final List<BookLite> books = new ArrayList<BookLite>();
	
	/**
	 * 
	 * @param books
	 */
	public Books(Collection<BookLite> books) {
		for (BookLite book : books) {
			this.books.add(book);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<BookLite> getBooks() {
		return Collections.unmodifiableList(books);
	}
}
