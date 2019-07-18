package com.rs.register;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.rs.model.UserData;
import com.rs.services.UserDaoImpl;


@Controller
@SessionAttributes("userData")
public class RegisterController {
	
	@Autowired
	UserDaoImpl userDaoImpl;

	
	@RequestMapping(value="/register", method= RequestMethod.GET )
	public String showRegisterPage(ModelMap model) {
		model.addAttribute("userData", new UserData("", "", "", Arrays.asList(" "))) ;
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String validate(ModelMap model,@ModelAttribute("userData")UserData userData) {
		List<String> favouriteCourse = new ArrayList<String>();
		userData.setCourses(favouriteCourse);
		if(userDaoImpl.find(userData.getEmail()) != null) {
			model.addAttribute("errorMessage", "You have already registerd");
			return "register";
		}
			
		userDaoImpl.create(userData);
		model.clear();
		model.addAttribute("userData", userData);
		return "redirect:/home";
	}
	
}
