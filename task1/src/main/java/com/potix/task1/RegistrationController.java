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
public class RegistrationController {
	@Autowired
	RegisterDAO rgDAO;
	

	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		  
	    ModelAndView mav = new ModelAndView("register");
	    UserModel um=new UserModel();
	    um.setFirstname("Rahul Ram");
	    mav.addObject("user", um);
	    return mav;
	  }
	
	  @RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	  public ModelAndView addUser(@ModelAttribute("user") UserModel user) {
		  
		  //invoke DAO class
		  int status=rgDAO.registerUser(user);

		  return new ModelAndView("regsuccess", "firstname", user.getFirstname());
	  }
}
