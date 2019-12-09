 package com.potix.task1;
import java.util.Iterator;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;
import org.zkoss.zul.*;

public class dbdemo extends Window {
protected TaskDAO taskDAO;


public void render() {
Textbox lb = (Textbox)this.getFellow("test");
System.out.println(lb.getValue());
taskDAO.call();
}
}
