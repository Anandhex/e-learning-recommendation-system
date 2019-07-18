package com.rs.login;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.rs.model.Courses;
import com.rs.model.UserData;
import com.rs.services.CourseDaoImpl;
import com.rs.services.UserDaoImpl;


@Controller
@SessionAttributes("userData")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Autowired
	private CourseDaoImpl courseDaoImpl;
	
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model,UserData userData,@RequestParam String email,@RequestParam String password ) {
		
		if (!loginService.validateUser(email,password)) {
			model.clear();
			model.addAttribute("errorMessage", "Invalid Credentials");
			return "login";
		}else {
		userData = userDaoImpl.find(email);
		model.put("userData", userData);
		List<Courses>courses=courseDaoImpl.listCoures();
		model.put("courses",courses );
		List<Courses> fav = new ArrayList<Courses>();
		List<String> favcourse = userData.getCourses();
		Iterator<String> itr = favcourse.iterator();
		while(itr.hasNext()) {
			fav.add(courseDaoImpl.findOne(itr.next()));
		}
		courses.removeAll(fav);
		
		model.addAttribute("courses", courses);
		if(courses.isEmpty()) {
			model.addAttribute("courseEmpty", "No courses avaliable");
		}
		
		return "redirect:/home";
		}
	}
}
