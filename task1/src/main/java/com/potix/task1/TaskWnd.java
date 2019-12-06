package com.potix.task1;

import java.util.Map;
import javax.servlet.ServletContext;



import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class TaskWnd extends Window {
	protected TaskDAO taskDAO;
	protected Task task;	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}	
	public void onCreate() {
		if (task != null) {
			//update
			Textbox ctrl = (Textbox) this.getFellow("title"); 
			ctrl.setValue(task.getTitle());
			ctrl = (Textbox) this.getFellow("description"); 
			ctrl.setValue(task.getDescription());
		}
		//spring bean, taskDAO
		ApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(
				(ServletContext)getDesktop().getWebApp().getNativeContext());
		taskDAO = (TaskDAO)ctx.getBean("taskDAO");
	}	
	public void onOK() throws Exception {
		if (task == null) {
			//new
			task = new Task();			
			Textbox ctrl = (Textbox) this.getFellow("title"); 
			task.setTitle(ctrl.getValue());
			ctrl = (Textbox) this.getFellow("description");
			task.setDescription(ctrl.getValue());			
			taskDAO.insert(task);
		} else {
			//update
			Textbox ctrl = (Textbox) this.getFellow("title"); 
			task.setTitle(ctrl.getValue());
			ctrl = (Textbox) this.getFellow("description");
			task.setDescription(ctrl.getValue());
			
			taskDAO.update(task);
		}
		
		this.setAttribute("OK", Boolean.TRUE);
		this.detach();
	}
	
	public void onCancle() {
		this.detach();
	}
}