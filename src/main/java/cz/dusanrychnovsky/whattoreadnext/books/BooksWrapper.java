package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BooksWrapper {

	private final List<Book> books = new ArrayList<Book>();
	
	/**
	 * 
	 * @param books
	 */
	public BooksWrapper(Collection<Book> books) {
		for (Book book : books) {
			this.books.add(book);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Book> getBooks() {
		return Collections.unmodifiableList(books);
	}
}
