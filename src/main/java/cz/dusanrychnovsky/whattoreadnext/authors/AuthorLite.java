package cz.dusanrychnovsky.whattoreadnext.authors;

public class AuthorLite {

	private final int id;
	private final String firstname;
	private final String lastname;
	
	/**
	 * 
	 * @param id
	 * @param firstname
	 * @param lastname
	 */
	public AuthorLite(final int id, final String firstname, final String lastname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
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
}
