package com.rs.services;

import java.util.List;

import com.rs.model.Comments;

public interface CommentsDao {
	public List<Comments> listComments(String courseName);
	
}
