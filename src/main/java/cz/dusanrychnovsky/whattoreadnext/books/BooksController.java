package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.dusanrychnovsky.whattoreadnext.authors.Author;
import cz.dusanrychnovsky.whattoreadnext.authors.AuthorNotFoundException;
import cz.dusanrychnovsky.whattoreadnext.authors.AuthorsRepository;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@RestController
@RequestMapping("/books")
public class BooksController {
	
	private final BooksRepository booksRepository;
	private final AuthorsRepository authorsRepository;
	
	/**
	 * 
	 * @param booksRepository
	 * @param authorsRepository
	 */
	@Autowired
	public BooksController(
		final BooksRepository booksRepository, 
		final AuthorsRepository authorsRepository) {
		
		this.booksRepository = booksRepository;
		this.authorsRepository = authorsRepository;
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

    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    public int addBook(@RequestBody final BookRequest request)
    	throws AuthorNotFoundException {
    	
    	Author author = authorsRepository.find(request.getAuthorId());
    	Book book = new Book(author, request.getTitle());
    	
    	return booksRepository.add(book);
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
    public Book getBook(@PathVariable(value="bookId") final int bookId) throws BookNotFoundException {
        return booksRepository.find(bookId);
    }
}
