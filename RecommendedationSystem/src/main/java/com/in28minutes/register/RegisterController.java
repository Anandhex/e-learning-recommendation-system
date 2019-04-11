package com.in28minutes.register;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.in28minutes.model.Courses;
import com.in28minutes.model.UserData;
import com.in28minutes.services.UserDaoImpl;


@Controller
public class RegisterController {
	
	@Autowired
	UserDaoImpl userDaoImpl;

	
	@RequestMapping(value="/register", method= RequestMethod.GET )
	public String showRegisterPage(ModelMap model) {
		model.addAttribute("user", new UserData("me", "me", "me", Arrays.asList(" "))) ;
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String validate(ModelMap model,UserData userData) {
		List<String> favouriteCourse = new ArrayList<String>();
		userData.setCourses(favouriteCourse);
		userDaoImpl.create(userData);
		model.clear();
		model.addAttribute("userData", userData);
		return "redirect:/login";
	}
	
}
