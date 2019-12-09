package com.potix.task1;

import java.util.*;
import javax.servlet.ServletContext;



import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

public class TaskListWnd extends Window {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected TaskDAO taskDAO;
	protected List tasks;
	
	protected void render() {
		Listbox lb = (Listbox)this.getFellow("taskslb");
		lb.getItems().clear();
		
		for (Iterator it = tasks.iterator(); it.hasNext(); ) {
			Task t = (Task) it.next();
			
			Listitem lt = new Listitem();
			lt.setValue(t);
			lt.appendChild(new Listcell(t.getTitle()));
			lt.appendChild(new Listcell(t.getDescription()));
			
			lb.appendChild(lt);
		}
	}
	
	public void onCreate() throws Exception {
		//	spring bean, taskDAO
		ApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(
				(ServletContext)getDesktop().getWebApp().getNativeContext());
		taskDAO = (TaskDAO)ctx.getBean("taskDAO");
        tasks = taskDAO.findAll();
		render();
	}
	
	public void onNew() throws Exception {
		Window win = (Window)Executions.createComponents("task.zul", null, null);
		win.doModal();
		if (win.getAttribute("OK") != null) {	//stupid
			tasks = taskDAO.findAll();
			render();
		}
	}
	
	public void onUpdate() throws Exception {
		Listbox lb = (Listbox)this.getFellow("taskslb");
		Listitem lt = lb.getSelectedItem();
		if (lt == null)
			return;
		Task t = (Task)lt.getValue();

		Map<String, Task> params = new HashMap<String, Task>();
		params.put("task", t);
		Window win = (Window)Executions.createComponents("task.zul", null, params);
		win.doModal();
		if (win.getAttribute("OK") != null) {	//stupid
			tasks = taskDAO.findAll();
			render();
		}
	}
	
	public void onDelete() throws Exception {
		Listbox lb = (Listbox)this.getFellow("taskslb");
		Listitem lt = lb.getSelectedItem();
		if (lt == null)
			return;
		Task t = (Task)lt.getValue();
		taskDAO.delete(t);
		lt.detach();
	}
}