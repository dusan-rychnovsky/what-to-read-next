package cz.dusanrychnovsky.whattoreadnext.books;

public class BookWrapper {

	private final Book book;

	/**
	 * 
	 * @param book
	 */
	public BookWrapper(Book book) {
		this.book = book;
	}
	
	/**
	 * 
	 * @return
	 */
	public Book getBook() {
		return book;
	}
}
