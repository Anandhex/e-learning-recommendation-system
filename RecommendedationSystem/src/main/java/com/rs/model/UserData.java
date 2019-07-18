package com.rs.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="UserData")
public class UserData {
	@Id
	private String id;
	private String firstName;
	private String email;
	private String password;
	private List<String> favouriteCourse;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favouriteCourse == null) ? 0 : favouriteCourse.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favouriteCourse == null) {
			if (other.favouriteCourse != null)
				return false;
		} else if (!favouriteCourse.equals(other.favouriteCourse))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public UserData() {
		super();
	}

	public UserData(String firstName, String email, String password,
			List<String> favouriteCourse) {
		super();
		
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.favouriteCourse = favouriteCourse;
	}
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ", firstName=" + firstName + ", email=" + email + ", password=" + password
				+ ", favouriteCourse=" + favouriteCourse + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getCourses() {
		return favouriteCourse;
	}
	public void setCourses(List<String> favouriteCourse) {
		this.favouriteCourse = favouriteCourse;
	}
	
}
