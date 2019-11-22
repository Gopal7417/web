package zk.web;
	import java.io.*;  
	import java.sql.*;  	  
	public class RetrieveFile {  
	public static void main(String[] args) {  
	try{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:oracle:thin:@localhost:1521:xe","system","123456");  	              
	PreparedStatement ps=con.prepareStatement("select * from FILETABLE "); 
	ResultSet rs=ps.executeQuery();  
	rs.next();//now on 1st row  	              
	Clob c=rs.getClob(2);  
	Reader r=c.getCharacterStream(); 
	
	FileWriter fw=new FileWriter("d:\\retrive.pdf");              
	int i;  
	while((i=r.read())!=-1)  
	fw.write((char)i);  	              
	fw.close();  
	con.close();	              
	System.out.println("success");  
	}catch (Exception e) {e.printStackTrace();  }  
	}  
	} 


