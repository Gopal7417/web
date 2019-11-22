package zk.web;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.activation.MimetypesFileTypeMap;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.io.Files;
import org.zkoss.util.media.AMedia;
import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.lowagie.text.pdf.RandomAccessFileOrArray;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class PropertyRetriever extends SelectorComposer<Window> {
    @Wire
    Textbox input; //wired to a component called input
    @Wire
    Vlayout result;
    
    @Wire
    Textbox input2;
    Reader r;
    
    String s;
    String s2 = new String();
    //wired to a component called result
     
    @Listen("onClick=#retrieve")
    public void submit(Event event) { //register a listener to a component called retrieve
        String prop = input.getValue();
     
        String me = input.getValue();
        
        
        Mail nw = new Mail();
        
       s = nw.main(me);
        
        
    }
    @Listen("onClick=#submit")
    public void submit2(Event event) {
    	
    s2 = input2.getValue();
    	
    	
     if(s.equals(s2))
     {
            result.appendChild(new Label("Success"));
     }
     
     else {
    	 result.appendChild(new Label("Enter correct OTP"));
     }
    	
    	
    }
    
    @Listen("onClick=#upload")
    public void download(Event event) {
    	
    	
    	 try{  
    		 
    		 System.out.println("coming");
     		Class.forName("oracle.jdbc.driver.OracleDriver");  
     		Connection con=DriverManager.getConnection(  
     		"jdbc:oracle:thin:@localhost:1521:xe","system","123456");  	              
     		PreparedStatement ps=con.prepareStatement("select * from FILETABLE "); 
     		ResultSet rs=ps.executeQuery();  
     		rs.next();//now on 1st row  	              
     		Clob c=rs.getClob(2);  
     		r=c.getCharacterStream();
     		
     		
     		}  	 
    	 catch (Exception e) {e.printStackTrace();    		
     		}    
 Filedownload.save(r,r.toString(), "Resume.pdf");
    }
    
    @Listen("onClick=#download")
    public void onUploadPDF(
            @ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
            throws IOException, ClassNotFoundException, SQLException {
 
        UploadEvent upEvent = null;
     Object objUploadEvent = ctx.getTriggerEvent();
      if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
     }
       if (upEvent != null) {
          Media media = upEvent.getMedia();
 		Connection cn;
        		  Class.forName("oracle.jdbc.driver.OracleDriver");
        	      cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");         
        	PreparedStatement ps=cn.prepareStatement(  
        	"insert into filetable values(?,?)");   
            Reader targetReader = new InputStreamReader(media.getStreamData());
            ps.setInt(1,101);
            ps.setCharacterStream(2,targetReader);  
            int i=ps.executeUpdate();  
            System.out.println(i);                           
            cn.close();  

      }
   
   }
    
    
}