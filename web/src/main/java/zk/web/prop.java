package zk.web;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

import zk.web.*;
 
public class prop extends Window {
    @Wire
    Textbox input; //wired to a component called input
    @Wire
    Vlayout result; //wired to a component called result
    @Wire
    Textbox input2;

    protected TaskDAO taskDAO;
    
    
   
    public void submit(Event event) { //register a listener to a component called retrieve
        String prop = input.getValue();
        taskDAO.hello("hello");
        input2.setValue(prop);
       
        
    }
}
