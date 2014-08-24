package cz.dusanrychnovsky.whattoreadnext.books;

import cz.dusanrychnovsky.whattoreadnext.EntityNotFoundException;

/**
 * An exception to indicate that a given book could not be found.
 * 
 * @author Dušan Rychnovský
 *
 */
public class BookNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param bookId
	 */
	public BookNotFoundException(final int bookId) {
		super("Book not found for ID ["+ bookId + "].");
	}
}
