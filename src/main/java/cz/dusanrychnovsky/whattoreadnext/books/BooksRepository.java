package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

import cz.dusanrychnovsky.whattoreadnext.authors.Author;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@Service
public class BooksRepository {
	
	private Map<Long, Book> books = new HashMap<>();
	
	{
		Random rand = new Random();
		
		Author andrzeiSapkowski = new Author(newId(rand), "Andrzej", "Sapkowski");
		
		Book mecOsudu = new Book(newId(rand), andrzeiSapkowski, "Meč osudu");
		books.put(mecOsudu.getId(), mecOsudu);
		
		Book posledniPrani = new Book(newId(rand), andrzeiSapkowski, "Poslední přání");
		books.put(posledniPrani.getId(), posledniPrani);
		
		Author terryPratchett = new Author(newId(rand), "Terry", "Pratchett");
		
		Book strazeStraze = new Book(newId(rand), terryPratchett, "Stráže! Stráže!");
		books.put(strazeStraze.getId(), strazeStraze);
		
		Author isaacAsimov = new Author(newId(rand), "Isaac", "Asimov");
		
		Book hvezdyJakoPrach = new Book(newId(rand), isaacAsimov, "Hvězdy jako prach");
		books.put(hvezdyJakoPrach.getId(), hvezdyJakoPrach);
	}
	
	/**
	 * 
	 * @param rand
	 * @return
	 */
	private int newId(Random rand) {
		return Math.abs(rand.nextInt());
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<Book> find() {
		return Collections.unmodifiableCollection(books.values());
	}
	
	/**
	 * 
	 * @param bookId
	 * @return
	 * @throws BookNotFoundException
	 */
	public Book find(long bookId) throws BookNotFoundException {
		if (!books.containsKey(bookId)) {
			throw new BookNotFoundException(bookId);
		}
		return books.get(bookId);
	}
}
