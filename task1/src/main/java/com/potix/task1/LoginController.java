package com.potix.task1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
	 @Autowired
	  RegisterDAO rgDAO;
	
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		  ModelAndView mav = new ModelAndView("login");
		  
		  LoginModel lm=new LoginModel();
		  lm.setUsername("Nimai");
		  mav.addObject("login", lm);
		  
		  mav.addObject("message","Please Enter your credentials");
		  return mav;
	  }
	
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("login") LoginModel login) {
	  
		  ModelAndView mav = null;
		  
		  //invoke DAO method to validate the user credentials
	      int ls = rgDAO.validateCredentials(login);
	      
	      //navigating based on the result
	      if (ls==0) {   //successful login
	    	  mav = new ModelAndView("loginsuccess");
	    	  mav.addObject("firstname", login.getUsername());
	      } else if (ls==1) {	//login failure with wrong pwd
	    	  mav = new ModelAndView("login");
	    	  mav.addObject("message", "Password is wrong!!");
	      } else if (ls==2) {		//login failure with wrong user
	    	  mav = new ModelAndView("login");
	    	  mav.addObject("message", "Username is wrong!!");
	      }
	      return mav;
	  }
}
