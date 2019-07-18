package com.in28minutes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.in28minutes.model.Courses;
import com.in28minutes.model.UserData;

@Repository
public class CourseDaoImpl	implements CourseDao {
	@Autowired
	MongoTemplate mongotemplate;
	
	public static final String COLLECTION="Course";
	
	@Override
	public List<Courses> listCoures() {
		// TODO Auto-generated method stub
		return mongotemplate.findAll(Courses.class,COLLECTION);
	}

	@Override
	public void addCourses(Courses courses) {
		// TODO Auto-generated method stub
		mongotemplate.save(courses);
		
	}

	@Override
	public Courses findOne(String name) {
		Query query = new Query(Criteria.where("courseName").is(name));	
		return mongotemplate.findOne(query, Courses.class,COLLECTION);
		
	}

	
}
