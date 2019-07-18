package com.in28minutes.home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.enterprise.inject.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.apriori.SlopeOne;
import com.in28minutes.model.Courses;
import com.in28minutes.model.Prefernces;
import com.in28minutes.model.UserData;
import com.in28minutes.services.CourseDaoImpl;
import com.in28minutes.services.UserDaoImpl;

import net.librec.recommender.ext.SlopeOneRecommender;

@Controller
	@SessionAttributes("userData")
public class HomeController {

	@Autowired
	CourseDaoImpl courseDaoImpl;
	@Autowired
	UserDaoImpl	userDaoImpl;
	
	 private final static Logger LOGGER =  
             Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	 public static List<String> removeDuplicates(List<String> favouriteCourse) 
	    { 
	  
	        // Create a new ArrayList 
	        List<String> newList = new ArrayList<String>(); 
	  
	        // Traverse through the first list 
	        for (String element : favouriteCourse) { 
	  
	            // If this element is not present in newList 
	            // then add it 
	            if (!newList.contains(element)) { 
	  
	                newList.add(element); 
	            } 
	        } 
	  
	        // return the new list 
	        return newList; 
	    }    
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String showHomePage(ModelMap model,@SessionAttribute("userData")UserData userData1) {
		List<Courses> course=courseDaoImpl.listCoures();
		List<Courses> fav = new ArrayList<Courses>(); 
		List<String> favcourse = userData1.getCourses();
		LOGGER.log(Level.INFO, "favcourse\n"+favcourse.toString());
		Iterator<String> itr = favcourse.iterator();
		while(itr.hasNext()) {
			fav.add(courseDaoImpl.findOne(itr.next()));
		}
		course.removeAll(fav);
		
		model.addAttribute("courses", course);
		return "home";
	}
	
	@RequestMapping(value="/home",  method=RequestMethod.POST)
	
	public String addBooks() {	
		return "add";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addCourse(ModelMap model,@RequestParam("courseName")String courseName,@RequestParam("email")String email) {
	
		Courses course = courseDaoImpl.findOne(courseName);
		UserData userData = userDaoImpl.find(email);
		String coursess =  course.getCourseName();
		List<String> favouriteCourse = new ArrayList<String>();
		if(!userData.getCourses().isEmpty()) 
				 favouriteCourse.addAll(userData.getCourses());
		favouriteCourse.add(coursess);
		List<String> resultFavouriteCourse = removeDuplicates(favouriteCourse);
		userData.setCourses(resultFavouriteCourse);
		userDaoImpl.update(userData);
		return "redirect:home";		
	}
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String saveCourse(@SessionAttribute("userData")UserData userData) {
		return "generate";
	}
	@RequestMapping(value="/getReco",method=RequestMethod.GET)

		public String getRecommendation(@SessionAttribute("userData")UserData userData,ModelMap model) {
		UserData userData1 = userDaoImpl.find(userData.getEmail());
		List<String> fav = recommend(userData1); 
		LOGGER.log(Level.INFO, "courseValuefinal"+fav.toString());
		Iterator ite = fav.iterator();
		List<Courses> course = new ArrayList<Courses>();
		
		while(ite.hasNext()) {
			
			course.add(courseDaoImpl.findOne((String)ite.next()));
		}
		
		LOGGER.log(Level.INFO, "courseValuefinal"+course.toString());
		model.addAttribute("courses", course);
		return "recommendation";
	}
	@RequestMapping(value="/addRecommended",method=RequestMethod.GET)
		public String showRecommendationPage(ModelMap model,@RequestParam("courseName")String courseName,@RequestParam("email")String email) {
		Courses course = courseDaoImpl.findOne(courseName);
		UserData userData = userDaoImpl.find(email);
		String coursess =  course.getCourseName();
		List<String> favouriteCourse = new ArrayList<String>();
		if(!userData.getCourses().isEmpty()) 
				 favouriteCourse.addAll(userData.getCourses());
		favouriteCourse.add(coursess);
		List<String> resultFavouriteCourse = removeDuplicates(favouriteCourse);
		userData.setCourses(resultFavouriteCourse);
		userDaoImpl.update(userData);
		
		return "generate";
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
			List<String> favouriteCourse = new ArrayList<String>();
			if(!userData.getCourses().isEmpty()) 
					 favouriteCourse.addAll(userData.getCourses());
			favouriteCourse.add(coursess);
			List<String> resultFavouriteCourse = removeDuplicates(favouriteCourse);
			userData.setCourses(resultFavouriteCourse);
			userDaoImpl.update(userData);
			
			return "generate";
		}
		
		
		
		public List<String> recommend(UserData userData1) {
			int count=0;
		List<UserData> userList = userDaoImpl.findAll();
			UserData userData = new UserData();
			LOGGER.log(Level.INFO, userList.toString());
			Iterator itr = userList.iterator();
			userData =(UserData)itr.next();
			List<String> compare = userData1.getCourses();
			LOGGER.log(Level.INFO,"Course to be compared:\n"+compare.toString());
			List<String> recommendation = new ArrayList<String>();
			
		while(itr.hasNext()) {
				userData = (UserData) itr.next();
				if(userData.getCourses().containsAll(compare)) {
					recommendation.addAll(userData.getCourses());
				}
		}
			LOGGER.log(Level.INFO, "fav course coming from the list\n"+recommendation.toString());
			recommendation= recommendation.stream().distinct().collect(Collectors.toList());
			LOGGER.log(Level.INFO, "fav course after removing duplicates the list\n"+recommendation.toString());
			recommendation.removeAll(compare);
			LOGGER.log(Level.INFO, "final fav course coming from the list\n"+recommendation.toString());
			int i = (int) (Math.random()*recommendation.size());
			recommendation.remove(i);
			LOGGER.log(Level.INFO, "fav course coming from the list\n"+recommendation.toString());
			
			
		return recommendation;
	}
}


