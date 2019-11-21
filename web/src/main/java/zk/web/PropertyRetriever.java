package zk.web;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;
 
public class PropertyRetriever extends SelectorComposer<Window> {
    @Wire
    Textbox input; //wired to a component called input
    @Wire
    Vlayout result;
    
    @Wire
    Textbox input2;
    
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
    
    
}