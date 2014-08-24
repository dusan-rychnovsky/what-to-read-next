package cz.dusanrychnovsky.whattoreadnext.books;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequest {

	private final int authorId;
	private final String title;
	
	/**
	 * 
	 * @param authorId
	 * @param title
	 */
	@JsonCreator
	public BookRequest(
		@JsonProperty("authorId") final int authorId,
		@JsonProperty("title") final String title) {
		
		this.authorId = authorId;
		this.title = title;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getAuthorId() {
		return authorId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
}
