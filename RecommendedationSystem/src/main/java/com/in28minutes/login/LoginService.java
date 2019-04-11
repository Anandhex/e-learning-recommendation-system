package com.in28minutes.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.model.UserData;
import com.in28minutes.services.UserDaoImpl;
@Service
public class LoginService {
	@Autowired
	private UserDaoImpl userDaoImpl;

	public boolean validateUser(String email,String password) {
		UserData userData;
		try{
			userData=userDaoImpl.find(email);
		
		if(password.equals(userData.getPassword())) {
			return true;
		}
		return false;
		}catch (Exception e) {
		// TODO: handle exception
		return false;
	}
	}
	
}
