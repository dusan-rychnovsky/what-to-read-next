package cz.dusanrychnovsky.whattoreadnext.books;

import cz.dusanrychnovsky.whattoreadnext.authors.Author;

/**
 * Represents a book.
 * 
 * @author Dušan Rychnovský
 *
 */
public class Book {

    private int id;
    private final Author author;
    private final String title;
    
    /**
     * 
     * @param author
     * @param title
     */
	public Book(final int id, final Author author, final String title) {
		this(author, title);
		this.id = id;
	}
	
	/**
	 * 
	 * @param author
	 * @param title
	 */
	public Book(final Author author, final String title) {
		this.author = author;
		this.title = title;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
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
