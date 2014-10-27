package cz.dusanrychnovsky.whattoreadnext.authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.query.QueryParameter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

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
	public Authors getAuthors(@RequestParam(value="ids[]") List<Integer> authorIds) {
		
		List<Author> authors = authorsRepository.find(authorIds);
		return new Authors(authors);
	}
}
