package cz.dusanrychnovsky.whattoreadnext.books;

import cz.dusanrychnovsky.whattoreadnext.authors.Author;

/**
 * Represents a book.
 * 
 * @author Dušan Rychnovský
 *
 */
public class Book {

    private final int id;
    private final Author author;
    private final String title;
    
    /**
     * 
     * @param id
     * @param author
     * @param title
     */
	public Book(final int id, final Author author, final String title) {
		this.id = id;
		this.author = author;
		this.title = title;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public Author getAuthor() {
		return author;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return "BOOK [" + id + ", " + author + ", " + title + "]";
	}
}
