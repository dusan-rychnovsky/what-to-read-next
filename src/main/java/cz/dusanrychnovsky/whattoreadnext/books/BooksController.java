package cz.dusanrychnovsky.whattoreadnext.books;

import cz.dusanrychnovsky.whattoreadnext.authors.AuthorNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@RestController
@RequestMapping("/books")
public class BooksController {
	
	private final BooksRepository booksRepository;
	
	/**
	 * 
	 * @param booksRepository
	 */
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
	public Collection<BookLite> getBooks() {
		return booksRepository.find();
	}

    @RequestMapping(value="/search", method=RequestMethod.POST, consumes="application/json")
    public Collection<BookLite> doSearch(@RequestBody final SearchCriteria criteria) {
    	return booksRepository.find(criteria);
    }
    
    @RequestMapping(value="/{bookId}", method=RequestMethod.GET)
    public Book getBook(@PathVariable("bookId") final int bookId)
    	throws BookNotFoundException {
    	
    	return booksRepository.find(bookId);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes="application/json")
    public int addBook(@RequestBody final BookRequest request)
    	throws AuthorNotFoundException {
    	
    	return booksRepository.add(request);
    }
}
