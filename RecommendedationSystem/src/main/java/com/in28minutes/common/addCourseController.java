package com.in28minutes.common;

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
import com.in28minutes.services.CourseDaoImpl;

@Controller
public class addCourseController {

	@Autowired
	CourseDaoImpl courseDaoImpl;
	
	@RequestMapping(value="/addCourse",method=RequestMethod.GET)
	public String showCourse(ModelMap model) {
		model.addAttribute("course", new Courses(""," "," "," ")) ;
		return "addCourse";
	}
	@RequestMapping(value="/addCourse",method=RequestMethod.POST)
	public String validate(ModelMap model,Courses course) {
		courseDaoImpl.addCourses(course);
		model.clear();
		model.addAttribute("course", new Courses(""," "," "," "));
		return "addCourse";
	}
	
}
