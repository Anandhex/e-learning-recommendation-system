package com.in28minutes.apriori;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.in28minutes.model.Courses;
import com.in28minutes.services.CourseDaoImpl;

public class InputData {
	@Autowired
	CourseDaoImpl courseDaoImpl;
	 List<Courses> courseList = courseDaoImpl.listCoures();
	 List<Courses> course1 = courseList;
	List<Item> items = load(courseList);
		 List<Item> load(List<Courses> courseList){
			
			List<Item> items = null;
			Iterator itr = courseList.iterator();
			while(itr.hasNext()) {
				Courses course = (Courses) itr.next();
				Item item = new Item();
				item.setItemName(course.getCourseName());
				items.add(item);
			}
			System.out.println(items.toString());
			return items;
			
		}
	
	
	    public  Map<User, HashMap<Item, Double>> initializeData(int numberOfUsers) {
	    	 List<Courses> courseList = courseDaoImpl.listCoures();
	    	List<Item> items = load(courseList);
	    	
	    	Map<User, HashMap<Item, Double>> data = new HashMap<>();
	        HashMap<Item, Double> newUser;
	        Set<Item> newRecommendationSet;
	        for (int i = 0; i < numberOfUsers; i++) {
	            newUser = new HashMap<Item, Double>();
	            newRecommendationSet = new HashSet<>();
	            for (int j = 0; j < 3; j++) {
	                newRecommendationSet.add(items.get((int) (Math.random() * 5)));
	            }
	            for (Item item : newRecommendationSet) {
	                newUser.put(item, Math.random());
	            }String uid = "User"+i;
	            data.put(new User(uid), newUser);
	        }
	        return data;
	    }
}
