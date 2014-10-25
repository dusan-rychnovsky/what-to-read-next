package cz.dusanrychnovsky.whattoreadnext.authors;

import cz.dusanrychnovsky.whattoreadnext.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param authorId
	 */
	public AuthorNotFoundException(final int authorId) {
		super("Author not found for ID ["+ authorId + "].");
	}
}
