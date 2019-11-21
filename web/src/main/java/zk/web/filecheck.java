package zk.web;
import java.io.File;
import java.io.*;
import java.io.BufferedInputStream;


public class filecheck {
	public static void main(String args[]) throws IOException{
		File f = new File("C:\\Users\\pennantstaff\\Downloads\\index.pdf");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		int b;
		if(f.isFile()){
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
		}
		else
			System.out.println("not found");
		while((b=bis.read())!=-1)
			System.out.print((char)b);
		}
}
