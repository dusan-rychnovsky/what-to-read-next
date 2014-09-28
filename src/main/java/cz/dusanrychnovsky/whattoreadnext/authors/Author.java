package cz.dusanrychnovsky.whattoreadnext.authors;

/**
 * Represents an author.
 * 
 * @author Dušan Rychnovský
 *
 */
public class Author {
	
	private final int id;
	private final String firstname;
	private final String lastname;
	
	/**
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 */
	public Author(final int id, final String firstname, final String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}


	/**
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}
	
	@Override
	public String toString() {
		return "AUTHOR [" + id + ", " + firstname + ", " + lastname + "]";
	}
}
