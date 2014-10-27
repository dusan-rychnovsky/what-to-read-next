package cz.dusanrychnovsky.whattoreadnext;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class Repository {    
    
	private final NamedParameterJdbcTemplate namedParameterjdbcTemplate;
	private final JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @param jdbcTemplate
	 */
	public Repository(final JdbcTemplate jdbcTemplate) {
		this.namedParameterjdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 */
	protected JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}
	
	/**
	 * 
	 * @return
	 */
	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterjdbcTemplate;
	}
}
