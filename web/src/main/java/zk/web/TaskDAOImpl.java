package zk.web;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;



import zk.web.TaskDAO;

public class TaskDAOImpl implements TaskDAO {
	
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void hello(String name) {
		
		String sql = "INSERT INTO tasks VALUES(?, ?)";
		String ee = new  String();
		String ee2 = new  String();
		 ee = "gopal";
		 ee2 = "gopalSS";
		 Object[] params = new Object[] {ee, ee2 };
			
			int types[] = new int[] { Types.VARCHAR, Types.VARCHAR};
			
			jdbcTemplate.update(sql, params,types);
	}

	
	
}
