package com.rs.home;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.rs.model.Courses;
import com.rs.model.UserData;
import com.rs.services.CourseDaoImpl;
import com.rs.services.UserDaoImpl;

@Controller
@SessionAttributes("userData")
public class HomeController {

	@Autowired
	CourseDaoImpl courseDaoImpl;
	@Autowired
	UserDaoImpl	userDaoImpl;
	
	  //controllers 
		@RequestMapping(value="/home", method=RequestMethod.GET)
		public String showHomePage(ModelMap model,@SessionAttribute("userData")UserData userData) {
		List<Courses> course = generateHome(userData);
		model.addAttribute("courses", course);
		if(course.isEmpty()) {
			model.addAttribute("courseEmpty", "No courses avaliable");
		}
		return "home";
		}
	
		@RequestMapping(value="/add",method=RequestMethod.GET)
		public String addCourse(ModelMap model,@RequestParam("courseName")String courseName,@RequestParam("email")String email) {
		Courses course = courseDaoImpl.findOne(courseName);
		int val = course.getNumber();
		val=val+1;
		course.setNumber(val);
		courseDaoImpl.update(course);
		UserData userData = userDaoImpl.find(email);
		String coursess =  course.getCourseName();
		update(userData, coursess);
		model.addAttribute("courses", generateHome(userData));
		return "home";		
		}
		@RequestMapping(value="/save",method=RequestMethod.GET)
		public String saveCourse(@SessionAttribute("userData")UserData userData) {
			return "generate";
		}
		@RequestMapping(value="/getReco",method=RequestMethod.GET)
		public String getRecommendation(@SessionAttribute("userData")UserData userData,ModelMap model) {
		UserData userData1 = userDaoImpl.find(userData.getEmail());
		model.addAttribute("courses", generate(userData1));
		return "recommendation";
		}

		@RequestMapping(value="/recommendation", method=RequestMethod.GET)
		public String showRecommendPage(ModelMap model,@SessionAttribute("userData")UserData userData) {
		UserData userData1 = userDaoImpl.find(userData.getEmail());
		model.addAttribute("courses", generate(userData1));
		return "recommendation";
		}
	
		@RequestMapping(value="/addRecommended",method=RequestMethod.GET)
		public String showRecommendationPage(ModelMap model,@RequestParam("courseName")String courseName,@RequestParam("email")String email) {
		Courses course = courseDaoImpl.findOne(courseName);
		UserData userData = userDaoImpl.find(email);
		String coursess =  course.getCourseName();
		update(userData, coursess);
		model.addAttribute("courses", generate(userData));
		return "recommendation";
		}
		@RequestMapping(value="/saveRecommended",method=RequestMethod.GET)
		public String addRecommended(ModelMap model) {
			return "generate";
		}
		@RequestMapping(value="/generate",method=RequestMethod.GET)
		public String showRecommendationPage(@RequestParam("courseName")String courseName,@RequestParam("email")String email) {
			Courses course = courseDaoImpl.findOne(courseName);
			UserData userData = userDaoImpl.find(email);
			String coursess =  course.getCourseName();
			update(userData, coursess);
			return "generate";
		}
		//functions
		public void update(UserData userData,String course) {
			List<String> favouriteCourse = new ArrayList<String>();
			if(!userData.getCourses().isEmpty()) 
					 favouriteCourse.addAll(userData.getCourses());
			favouriteCourse.add(course);
			List<String> resultFavouriteCourse = removeDuplicates(favouriteCourse);
			userData.setCourses(resultFavouriteCourse);
			userDaoImpl.update(userData);
		}
		
		public List<Courses> generate(UserData userData){
			List<String> fav = recommend(userData); 
			Iterator<String> ite = fav.iterator();
			List<Courses> course = new ArrayList<Courses>();
			while(ite.hasNext()) {	
				course.add(courseDaoImpl.findOne((String)ite.next()));
			}
			return course;
		}
		
		public List<String> recommend(UserData userData1) {
		List<UserData> userList = userDaoImpl.findAll();
		UserData userData = new UserData();
		Iterator<UserData> itr = userList.iterator();
		userData =(UserData)itr.next();
		List<String> compare = userData1.getCourses();
		List<String> recommendation = new ArrayList<String>();
		while(itr.hasNext()) {
				userData = (UserData) itr.next();
				if(userData.getCourses().containsAll(compare)) {
					recommendation.addAll(userData.getCourses());
				}
		}
		recommendation= recommendation.stream().distinct().collect(Collectors.toList());
		recommendation.removeAll(compare);
		int i = (int) (Math.random()*recommendation.size());
		recommendation.remove(i);
		return recommendation;
		}
		public List<Courses> generateHome(UserData userData){
			List<Courses> course=courseDaoImpl.listCoures();
			List<Courses> fav = new ArrayList<Courses>(); 
			List<String> favcourse = userData.getCourses();
			Iterator<String> itr = favcourse.iterator();
			while(itr.hasNext()) {
				fav.add(courseDaoImpl.findOne(itr.next()));
			}
			course.removeAll(fav);
			return course;
		}
		
		public static List<String> removeDuplicates(List<String> favouriteCourse) { 
	        List<String> newList = new ArrayList<String>(); 
	        for (String element : favouriteCourse) { 
	            if (!newList.contains(element)) { 
	                newList.add(element); 
	            } 
	        } 
	        return newList; 
	    }
}


