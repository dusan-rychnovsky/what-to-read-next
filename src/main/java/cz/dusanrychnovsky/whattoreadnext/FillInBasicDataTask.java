package cz.dusanrychnovsky.whattoreadnext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cz.dusanrychnovsky.whattoreadnext.authors.Author;
import cz.dusanrychnovsky.whattoreadnext.authors.AuthorsRepository;
import cz.dusanrychnovsky.whattoreadnext.books.Book;
import cz.dusanrychnovsky.whattoreadnext.books.BooksRepository;

@Component
public class FillInBasicDataTask implements ApplicationListener<ContextRefreshedEvent>{

	private final AuthorsRepository authorsRepository;
	private final BooksRepository booksRepository;
	
	/**
	 * 
	 * @param booksRepository
	 * @param authorsRepository
	 */
	@Autowired
	public FillInBasicDataTask(
		final BooksRepository booksRepository, 
		final AuthorsRepository authorsRepository) {
		
		this.booksRepository = booksRepository;
		this.authorsRepository = authorsRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		// Andrzei Sapkowski
		//
		Author andrzeiSapkowski = new Author("Andrzei", "Sapkowski");
		
		int andrzeiSapkowskiId = authorsRepository.add(andrzeiSapkowski);
		andrzeiSapkowski.setId(andrzeiSapkowskiId);
		
		Book mecOsudu = new Book(andrzeiSapkowski, "Meč osudu");
		booksRepository.add(mecOsudu);
		
		Book posledniPrani = new Book(andrzeiSapkowski, "Poslední přání");
		booksRepository.add(posledniPrani);
		
		// Terry Pratchett
		//
		Author terryPratchett = new Author("Terry", "Pratchett");
		
		int terryPratchettId = authorsRepository.add(terryPratchett);
		terryPratchett.setId(terryPratchettId);
		
		Book strazeStraze = new Book(terryPratchett, "Stráže! Stráže!");
		booksRepository.add(strazeStraze);
	}
}
