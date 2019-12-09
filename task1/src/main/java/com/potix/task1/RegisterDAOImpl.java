package com.potix.task1;

import org.springframework.jdbc.core.JdbcTemplate;

public class RegisterDAOImpl implements RegisterDAO {
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate t) {
		template=t;
	}
	
public int registerUser(UserModel user){
		
		//prepare the insert statement
	    String qry = "insert into users values(?,?,?,?,?,?,?)";

	    //execute the DML statement
	    int st=template.update(qry, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),user.getLastname(), user.getEmail(), user.getQual(), user.getMobile() });
	    
		return st;
			}
public int validateCredentials(LoginModel lm) {
	
	//get the password for the given user
	String qry = "select pass from users where username=?";
	
	try {
	String pwd = (String)template.queryForObject(qry,new Object[]{lm.getUsername()}, String.class );
	
	//verify the password
	if (pwd != null) {
		if (lm.getPassword().equals(pwd)) {
			return 0;	//success
		}else {
			return 1;	//wrong password
		}
	}else {
		return 2;
	}
	
	}catch(Exception ex) {
		return 2;	//user itself wrong
	}
	
}
}
