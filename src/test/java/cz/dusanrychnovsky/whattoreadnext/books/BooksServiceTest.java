package cz.dusanrychnovsky.whattoreadnext.books;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

public class BooksServiceTest {
	
	private BooksRepository booksService = new BooksRepository();
	
	@Test
	public void canRetrieveAnExistingBook() throws BookNotFoundException {
		
		Collection<Book> books = booksService.find();
		Book book = books.iterator().next();
		
		int bookId = book.getId();
		Book result = booksService.find(bookId);
		
		assertEquals(bookId, result.getId());
	}
}
