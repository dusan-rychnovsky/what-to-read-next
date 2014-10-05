package cz.dusanrychnovsky.whattoreadnext.books;

import cz.dusanrychnovsky.whattoreadnext.authors.AuthorNotFoundException;
import cz.dusanrychnovsky.whattoreadnext.ratings.Opinion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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
	@RequestMapping(method=GET)
	public Collection<BookLite> getBooks() {
		return booksRepository.find();
	}

    @RequestMapping(value="/search", method=POST, consumes="application/json")
    public Collection<BookLite> doSearch(@RequestBody final SearchCriteria criteria) {
    	return booksRepository.find(criteria);
    }
    
    @RequestMapping(value="/{bookId}", method=GET)
    public Book getBook(@PathVariable("bookId") final int bookId)
    	throws BookNotFoundException {
    	
    	return booksRepository.find(bookId);
    }
    
    @RequestMapping(method=POST, consumes="application/json")
    public int addBook(@RequestBody final BookRequest request)
    	throws AuthorNotFoundException {
    	
    	return booksRepository.add(request);
    }
    
    @RequestMapping(value="/{bookId}/opinion", method=PUT)
    public void setOpinion(
    	@PathVariable final int bookId, 
    	@RequestBody final Opinion opinion)
    	throws BookNotFoundException {
    	
    	booksRepository.setOpinion(bookId, opinion);
    }
}
