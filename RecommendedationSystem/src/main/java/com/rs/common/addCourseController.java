package com.rs.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rs.model.Courses;
import com.rs.services.CourseDaoImpl;

@Controller
public class addCourseController {

	@Autowired
	CourseDaoImpl courseDaoImpl;
	
	@RequestMapping(value="/addCourse",method=RequestMethod.GET)
	public String showCourse(ModelMap model) {
		model.addAttribute("course", new Courses(""," "," "," ",0)) ;
		return "addCourse";
	}
	@RequestMapping(value="/addCourse",method=RequestMethod.POST)
	public String validate(ModelMap model,Courses course) {
		courseDaoImpl.addCourses(course);
		model.clear();
		model.addAttribute("course", new Courses(""," "," "," ",0));
		return "addCourse";
	}
	
}
