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
	private final String surname;
	
	/**
	 * 
	 * @param id
	 * @param firstname
	 * @param surname
	 */
	public Author(final int id, final String firstname, final String surname) {
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
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
	public String getSurname() {
		return surname;
	}
	
	@Override
	public String toString() {
		return "AUTHOR [" + id + ", " + firstname + ", " + surname + "]";
	}
}
