package cz.dusanrychnovsky.whattoreadnext;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class Repository {    
    
	private final JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 * @param jdbcTemplate
	 */
	public Repository(final JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 */
	protected JdbcTemplate getTemplate() {
		return jdbcTemplate;
	}
}
