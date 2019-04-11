package com.in28minutes.services;

import java.util.List;

import com.in28minutes.model.Courses;

public interface CourseDao {
	public List<Courses> listCoures();
	public void addCourses(Courses courses);
	public Courses findOne(String id);
	
}
