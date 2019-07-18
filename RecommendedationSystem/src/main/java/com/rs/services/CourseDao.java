package com.rs.services;

import java.util.List;

import com.rs.model.Courses;

public interface CourseDao {
	public List<Courses> listCoures();
	public void addCourses(Courses courses);
	public Courses findOne(String id);
	void update(Courses courses);
	
}
