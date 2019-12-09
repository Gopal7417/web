 package com.potix.task1;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

public class dbdemo extends Window {
protected TaskDAO taskDAO;


public void render() {
Textbox lb = (Textbox)this.getFellow("test");
Textbox lb1 = (Textbox)this.getFellow("test2");


String hello="hiee";
System.out.println(lb1.getValue());
}


public void onCreate() {
//update
	Textbox lb = (Textbox)this.getFellow("test");
		lb.setValue("Hello");
//spring bean, taskDAO
	ApplicationContext ctx = 
		WebApplicationContextUtils.getRequiredWebApplicationContext(
			(ServletContext)getDesktop().getWebApp().getNativeContext());
	taskDAO = (TaskDAO)ctx.getBean("taskDAO");
}	

}
