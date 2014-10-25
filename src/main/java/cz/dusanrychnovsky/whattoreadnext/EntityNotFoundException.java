package cz.dusanrychnovsky.whattoreadnext;

/**
 * An exception to indicate that a given entity could not be found.
 * 
 * @author Dušan Rychnovský
 *
 */
public class EntityNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public EntityNotFoundException(final String message) {
		super(message);
	}
}
