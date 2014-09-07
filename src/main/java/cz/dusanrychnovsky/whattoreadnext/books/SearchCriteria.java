package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchCriteria {

	private final List<String> keywords;
	
	/**
	 * 
	 * @param keywords
	 */
	public SearchCriteria(final List<String> keywords) {
		this.keywords = new ArrayList<String>(keywords);
	}
	
	/**
	 * 
	 */
	public SearchCriteria() {
		keywords = new ArrayList<String>();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getKeywords() {
		return Collections.unmodifiableList(keywords);
	}
}
