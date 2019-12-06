package com.potix.task1;

import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;
import javax.sql.*;

import java.io.IOException;
 
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.fileupload.FileUpload;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

public class TaskDAOImpl implements TaskDAO {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	protected DataFieldMaxValueIncrementer taskIncer;
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setJdbcTemplate(JdbcTemplate  jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTaskIncer(DataFieldMaxValueIncrementer taskIncer) {
		this.taskIncer = taskIncer;
	}

	public Task insert(Task t) throws Exception {

		String sql = "INSERT INTO tasks VALUES(?, ?)";
		Object[] params = new Object[] { t.getTitle(), t.getDescription() };
		int types[] = new int[] { Types.VARCHAR, Types.VARCHAR};
		jdbcTemplate.update(sql, params,types);
		
		return t;
	}

	public Task update(Task t) throws Exception {
		String sql = "UPDATE tasks SET title = ?, description = ? WHERE id = ?";
		Object[] params = new Object[] { t.getTitle(), t.getDescription(), t.getId() };
		int types[] = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
		jdbcTemplate.update(sql, params, types);
		
		return t;
	}

	public void delete(Task t) throws Exception {
		String sql = "DELETE FROM tasks WHERE id = ?";
		Object[] params = new Object[] { t.getId() };
		int types[] = new int[] { Types.INTEGER};
		jdbcTemplate.update(sql, params, types);
	}

	protected class TaskMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Task t = new Task();
			t.setId(rs.getInt("id"));
			t.setTitle(rs.getString("title"));
			t.setDescription(rs.getString("description"));			
			return t;
		}
	}
	public Task findById(int id) throws Exception {
		String sql = "SELECT * FROM tasks WHERE id = ?";
		Object[] params = new Object[] { id };
		int types[] = new int[] { Types.INTEGER};
		
		List ts = jdbcTemplate.query(sql, params, types, new TaskMapper());
		if (ts.isEmpty())
			return null;
		return (Task)ts.get(0); 
	}
	public List findAll() throws Exception {
		String sql = "SELECT * FROM tasks";
		return jdbcTemplate.query(sql, new TaskMapper());
	}	
	public void call() {
System.out.println("1st enter");
		String sql = "INSERT INTO tasks VALUES(?, ?)";
		String ee = "hello";
		String e2 = "gopal";
		System.out.println("enter");
		Object[] params = new Object[] {ee, e2 };
		int types[] = new int[] { Types.VARCHAR, Types.VARCHAR};
		jdbcTemplate.update(sql, params,types);		
		System.out.println("Leave");
	}
	public void insertImage(){
		System.out.println("1st enter");
try {
			 
		   final File image = new File("C:\\Users\\pennantstaff\\Downloads\\index.pdf");
		   final InputStream imageIs = new FileInputStream(image);  
		   Reader targetReader = new InputStreamReader(imageIs);
		   
		   ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		   int reads = imageIs.read(); 
		   while(reads != -1){ baos.write(reads);
		   reads = imageIs.read(); }

		//javarevisited.blogspot.com/2013/04/how-to-convert-inputstream-to-byte-array-java-example-tutorial.html#ixzz67In2orCj
		   int insertCount = jdbcTemplate.update("INSERT INTO mine VALUES (?)",baos.toByteArray());
		/*  LobHandler lobHandler = new DefaultLobHandler(); 
		  FileUpload fileUploadObj = new FileUpload();
          fileUploadObj.setFileName(aFile.getOriginalFilename());
          fileUploadObj.setFileDescription(fileDescription);
          fileUploadObj.setData(aFile.getBytes());
		 /*  jdbcTemplate.update
		         "INSERT INTO mine VALUES (?)",
		         new Object[] {new SqlLobValue(imageIs, (int)image.length(), lobHandler),}, new int[] {Types.VARBINARY});
		   /*	String sql = "INSERT INTO mine VALUES (?)";
		   Object[] params = new Object[] {imageIs };
			int types[] = new int[] { Types.BLOB}; 
		   jdbcTemplate.update(sql, params,types); */
		  } catch (DataAccessException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  } catch (IOException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  }
			System.out.println("Leave");
		
	
	}
	
}
	

	
	
	
