package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCriteria {

	private final List<String> keywords;
	
	/**
	 * 
	 * @param keywords
	 */
	@JsonCreator
	public SearchCriteria(
		@JsonProperty("keywords") final List<String> keywords) {
		
		this.keywords = new ArrayList<String>(keywords);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getKeywords() {
		return Collections.unmodifiableList(keywords);
	}
}
