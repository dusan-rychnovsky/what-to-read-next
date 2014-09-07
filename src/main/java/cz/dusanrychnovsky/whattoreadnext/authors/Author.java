package cz.dusanrychnovsky.whattoreadnext.authors;

/**
 * Represents an author.
 * 
 * @author Dušan Rychnovský
 *
 */
public class Author {
	
	private int id;
	private final String firstname;
	private final String lastname;
	
	/**
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 */
	public Author(final int id, final String firstname, final String lastname) {
		this(firstname, lastname);
		this.id = id;
	}
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 */
	public Author(final String firstname, final String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
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
