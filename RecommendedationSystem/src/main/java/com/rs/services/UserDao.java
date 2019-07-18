package com.rs.services;

import java.util.List;

import com.rs.model.UserData;

public interface UserDao {
	public List<UserData> findAll();
	public void create (UserData userData);
	public void update(UserData userData);
	public UserData find(UserData userData);
	public void delete(UserData userData);
	public UserData find(String email);
}
