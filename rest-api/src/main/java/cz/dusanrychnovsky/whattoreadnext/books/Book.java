package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cz.dusanrychnovsky.whattoreadnext.authors.AuthorLite;
import cz.dusanrychnovsky.whattoreadnext.ratings.Opinion;

/**
 * Represents a book.
 * 
 * @author Dušan Rychnovský
 *
 */
public class Book {

	private final int id;
	private final List<AuthorLite> authors;
	private final String title;
	private final String description;
	private final String imageUrl;
	private Opinion opinion = Opinion.NEUTRAL;
    
	/**
	 * 
	 * @param id
	 * @param authors
	 * @param title
	 * @param description
	 * @param imageUrl
	 */
	public Book(final int id, final List<AuthorLite> authors, final String title,
		final String description, final String imageUrl) {
		
		this.id = id;
		this.authors = new ArrayList<AuthorLite>(authors);
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param description
	 * @param imageUrl
	 */
	public Book(final int id, final String title, final String description,
		final String imageUrl) {
		
		this(
			id,
			Collections.<AuthorLite>emptyList(),
			title,
			description,
			imageUrl
		);
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
	 * @param author
	 */
	public void addAuthor(final AuthorLite author) {
		authors.add(author);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<AuthorLite> getAuthors() {
		return Collections.unmodifiableList(authors);
	}
	
	/**
	 * 
	 * @param authors
	 */
	public void setAuthors(Collection<AuthorLite> authors) {
		for (AuthorLite author : authors) {
			addAuthor(author);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	
	/**
	 * 
	 * @return
	 */
	public Opinion getOpinion() {
		return opinion;
	}
	
	/**
	 * 
	 * @param opinion
	 */
	public void setOpinion(final Opinion opinion) {
		this.opinion = opinion;
	}
}