package cz.dusanrychnovsky.whattoreadnext.books;

import cz.dusanrychnovsky.whattoreadnext.ratings.Opinion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Represents a book.
 * 
 * @author Dušan Rychnovský
 *
 */
@JsonRootName("book")
public class Book {

	private final Integer id;
	private final List<Integer> authors;
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
	public Book(final int id, final List<Integer> authors, final String title,
		final String description, final String imageUrl) {
		
		this.id = id;
		this.authors = new ArrayList<Integer>(authors);
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
			Collections.<Integer>emptyList(),
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
	 * @param authorId
	 */
	public void addAuthor(final Integer authorId) {
		authors.add(authorId);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Integer> getAuthors() {
		return Collections.unmodifiableList(authors);
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
