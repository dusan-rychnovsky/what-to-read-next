package cz.dusanrychnovsky.whattoreadnext.authors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an author.
 * 
 * @author Dušan Rychnovský
 *
 */
public class Author {
	
	private final Integer id;
	private final List<Integer> books;
	private final String firstname;
	private final String lastname;
	
	/**
	 * 
	 * @param id
	 * @param books
	 * @param firstname
	 * @param lastname
	 */
	public Author(
		final Integer id,
		final List<Integer> books,
		final String firstname,
		final String lastname) {
		
		this.id = id;
		this.books = new ArrayList<Integer>(books);
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/**
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 */
	public Author(
		final Integer id,
		final String firstname,
		final String lastname) {
		
		this(
			id,
			Collections.<Integer>emptyList(),
			firstname,
			lastname
		);
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param bookId
	 */
	public void addBook(Integer bookId) {
		books.add(bookId);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Integer> getBooks() {
		return Collections.unmodifiableList(books);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}
	
	@Override
	public String toString() {
		return "AUTHOR [" + id + ", " + firstname + ", " + lastname + "]";
	}
}
