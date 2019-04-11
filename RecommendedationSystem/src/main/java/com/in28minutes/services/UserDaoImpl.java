package com.in28minutes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.in28minutes.model.UserData;

@Repository

public class UserDaoImpl implements UserDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	final String COLLECTION= "UserData";
	
	public void create(UserData userData) {
		mongoTemplate.insert(userData);
	}

	@Override
	public void update(UserData userData) {
		// TODO Auto-generated method stub
		mongoTemplate.save(userData);
	}

	@Override
	public UserData find(UserData userData) {
		 Query query = new Query(Criteria.where("_id").is(userData.getId()));
	        return mongoTemplate.findOne(query, UserData.class, COLLECTION);
	}

	@Override
	public void delete(UserData userData) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(userData);
		
	}

	@Override
	public UserData find(String email) {
		Query query = new Query(Criteria.where("email").is(email));	
		return mongoTemplate.findOne(query, UserData.class,COLLECTION);
	}

	@Override
	public List<UserData> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(UserData.class, COLLECTION);
	}
	
}
