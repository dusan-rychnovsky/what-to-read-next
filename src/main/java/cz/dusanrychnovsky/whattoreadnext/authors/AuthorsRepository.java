package cz.dusanrychnovsky.whattoreadnext.authors;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import cz.dusanrychnovsky.whattoreadnext.Repository;

@Service
public class AuthorsRepository extends Repository {
	
	private final Map<Integer, Author> authors = new HashMap<>();
	
	/**
	 * 
	 * @param authorId
	 * @return
	 * @throws AuthorNotFoundException
	 */
	public Author find(final int authorId) throws AuthorNotFoundException {
		if (!authors.containsKey(authorId)) {
			throw new AuthorNotFoundException(authorId);
		}
		return authors.get(authorId);
	}
	
	/**
	 * 
	 * @param author
	 * @return
	 */
	public int add(final Author author) {
		int id = newId();
		author.setId(id);
		authors.put(id, author);
		return id;
	}
}
