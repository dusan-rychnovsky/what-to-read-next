package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@RestController
@RequestMapping("/books")
public class BooksController {
	
	private final BooksRepository booksRepository;
	
	@Autowired
	public BooksController(final BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	/**
	 * Returns the list of all registered books.
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Book> getBooks() {
		return booksRepository.find();
	}
	
	/**
	 * Returns a book corresponding to the given ID. Throws an exception
	 * if such a book does not exist.
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException
	 */
    @RequestMapping(value="/{bookId}", method=RequestMethod.GET)
    public Book getBook(@PathVariable(value="bookId") final long bookId) throws BookNotFoundException {
        return booksRepository.find(bookId);
    }
}
