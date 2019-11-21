package zk.web;

import java.io.*;  
import java.sql.*;  
  
public class StoreFile {  
public static void main(String[] args) {  
try{  
	Connection cn;
	  Class.forName("oracle.jdbc.driver.OracleDriver");
      cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
              
PreparedStatement ps=cn.prepareStatement(  
"insert into filetable values(?,?)");  
              
File f=new File("C:\\Users\\pennantstaff\\Downloads\\1205-131014012548-phpapp02.pdf");  
FileReader fr=new FileReader(f);  
              
ps.setInt(1,101);  
ps.setCharacterStream(2,fr,(int)f.length());  
int i=ps.executeUpdate();  
System.out.println(i+" records affected");  
              
cn.close();  
              
}catch (Exception e) {e.printStackTrace();}  
}  
}  