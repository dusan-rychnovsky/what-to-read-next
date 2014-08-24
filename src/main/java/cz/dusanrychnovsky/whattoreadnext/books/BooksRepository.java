package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import cz.dusanrychnovsky.whattoreadnext.Repository;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@Service
public class BooksRepository extends Repository {
	
	private Map<Integer, Book> books = new HashMap<>();
	
	/**
	 * 
	 * @return
	 */
	public Collection<Book> find() {
		return Collections.unmodifiableCollection(books.values());
	}
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException
	 */
	public Book find(int bookId) throws BookNotFoundException {
		if (!books.containsKey(bookId)) {
			throw new BookNotFoundException(bookId);
		}
		return books.get(bookId);
	}
	
	/**
	 * 
	 * @param book
	 * @return
	 */
	public int add(Book book) {
		int id = newId();
		book.setId(id);
		books.put(id, book);
		return id;
	}
}
