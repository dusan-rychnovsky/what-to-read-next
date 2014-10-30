package cz.dusanrychnovsky.whattoreadnext.books;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class SearchQueryBuilder {

	private final List<String> keywords = new LinkedList<String>();
	
	/**
	 * 
	 * @return
	 */
	public SearchQueryBuilder clear() {
		keywords.clear();
		return this;
	}

	/**
	 * 
	 * @param keywords
	 * @return
	 */
	public SearchQueryBuilder addKeywords(final List<String> keywords) {
		for (String keyword : keywords) {
			add(keyword);
		}
		return this;
	}
	
	/**
	 * 
	 * @param keyword
	 * @return
	 */
	private SearchQueryBuilder add(final String keyword) {
		keywords.add(keyword);
		return this;
	}
	
	/**
	 * 
	 * @return
	 */
	public String buildQuery() {
		
		// TODO: fix a bug in this query - when searching by author only returns
		// the rows with that author
		
		StringBuilder result = new StringBuilder();
		result.append("SELECT * ");
		result.append("FROM Books NATURAL JOIN Authorship NATURAL JOIN Authors ");
		
		List<String> whereClauses = new LinkedList<String>();
		for (int i = 0; i < keywords.size(); i++) {
			whereClauses.add(
				"(firstname LIKE ? OR lastname LIKE ? OR title LIKE ?)"
			);
		}
		
		if (!whereClauses.isEmpty()) {
			result.append("WHERE " + StringUtils.join(whereClauses, " AND "));
		}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	public Object[] buildParams() {
		
		List<Object> params = new LinkedList<>();
		for (String keyword : keywords) {
			params.add('%' + keyword + '%');
			params.add('%' + keyword + '%');
			params.add('%' + keyword + '%');
		}
		
		return params.toArray();
	}
}
