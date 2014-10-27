package cz.dusanrychnovsky.whattoreadnext.authors;

import java.util.ArrayList;
import java.util.List;

public class Authors {

	private final List<Author> authors = new ArrayList<Author>();

	/**
	 * 
	 * @param authors
	 */
	public Authors(List<Author> authors) {
		for (Author author : authors) {
			this.authors.add(author);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Author> getAuthors() {
		return authors;
	}
}
