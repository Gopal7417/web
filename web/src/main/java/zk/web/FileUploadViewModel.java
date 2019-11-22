package zk.web;
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
public class FileUploadViewModel {
Reader r ;
   private String filePath;
    private boolean fileuploaded = false;
   AMedia fileContent;
 
 @Wire("#test")
  private Window win;
 
 public AMedia getFileContent() {
        return fileContent;
 }
 
   public void setFileContent(AMedia fileContent) {
        this.fileContent = fileContent;
 }
 
   public boolean isFileuploaded() {
       return fileuploaded;
    }
 
   public void setFileuploaded(boolean fileuploaded) {
     this.fileuploaded = fileuploaded;
   }
 
   @AfterCompose
   public void initSetup(@ContextParam(ContextType.VIEW) Component view)
             {
     Selectors.wireComponents(view, this, false);
      
   }
 
   @Command
    @NotifyChange("fileuploaded")
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
          
           Calendar now = Calendar.getInstance();
          int year = now.get(Calendar.YEAR);
          int month = now.get(Calendar.MONTH); // Note: zero based!
           int day = now.get(Calendar.DAY_OF_MONTH);
           filePath = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/"); 
         File baseDir = new File(filePath);    
        		Connection cn;
        		  Class.forName("oracle.jdbc.driver.OracleDriver");
        	      cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");         
        	PreparedStatement ps=cn.prepareStatement(  
        	"insert into filetable values(?,?)");  
         System.out.println(filePath); 
          if (!baseDir.exists()) {
                baseDir.mkdirs();
           }
           Files.copy(new File(filePath + media.getName()),
                    media.getStreamData());
         Messagebox.show("File Sucessfully uploaded in the path [ ."
                 + filePath + " ]");
         fileuploaded = true;
            filePath = filePath + media.getName();                      
            File f=new File(filePath);         
            FileReader fr=new FileReader(f);     
            Reader targetReader = new InputStreamReader(media.getStreamData());
            ps.setInt(1,101);
            ps.setCharacterStream(2,targetReader,(int)f.length());  
            int i=ps.executeUpdate();  
            System.out.println(i);                           
            cn.close();  

      }
   
   }

   @Command
    @NotifyChange("fileContent")
    public void showPDF() throws IOException {
      File f = new File(filePath);
        Messagebox.show(" dfdfdfdsfdsf" + filePath);
        byte[] buffer = new byte[(int) f.length()];
     FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
     ByteArrayInputStream is = new ByteArrayInputStream(buffer);
     fileContent = new AMedia("report", "pdf", "application/pdf", is);     
     FileInputStream inputStream;
  try{  
    		Class.forName("oracle.jdbc.driver.OracleDriver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@localhost:1521:xe","system","123456");  	              
    		PreparedStatement ps=con.prepareStatement("select * from FILETABLE "); 
    		ResultSet rs=ps.executeQuery();  
    		rs.next();//now on 1st row  	              
    		Clob c=rs.getClob(2);  
    		r=c.getCharacterStream();    	
    		}catch (Exception e) {e.printStackTrace();  } 

  
Filedownload.save(r,r.toString(), "Resume.pdf");
   }
  
}