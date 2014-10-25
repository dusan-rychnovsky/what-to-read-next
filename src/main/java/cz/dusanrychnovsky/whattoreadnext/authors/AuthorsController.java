package cz.dusanrychnovsky.whattoreadnext.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 
 * @author Dušan Rychnovský
 *
 */
@RestController
@RequestMapping("/authors")
public class AuthorsController {
	
	private final AuthorsRepository authorsRepository;
	
	/**
	 * 
	 * @param authorsRepository
	 */
	@Autowired
	public AuthorsController(final AuthorsRepository authorsRepository) {
		this.authorsRepository = authorsRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<AuthorLite> getBooks() {
		return authorsRepository.find();
	}
}
