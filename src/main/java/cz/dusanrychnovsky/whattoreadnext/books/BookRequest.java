package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequest {

	private final List<Integer> authorIds;
	private final String title;
	private final String description;
	private final String imageUrl;
	
	/**
	 * 
	 * @param authorIds
	 * @param title
	 * @param description
	 * @param imageUrl
	 */
	@JsonCreator
	public BookRequest(
		@JsonProperty("authorIds") final Collection<Integer> authorIds,
		@JsonProperty("title") final String title,
		@JsonProperty("description") final String description,
		@JsonProperty("imageUrl") final String imageUrl) {
		
		this.authorIds = new ArrayList<Integer>(authorIds);
		this.title = title;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	/**
	 * 
	 * @return
	 */
	public Collection<Integer> getAuthorIds() {
		return Collections.unmodifiableList(authorIds);
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
}
