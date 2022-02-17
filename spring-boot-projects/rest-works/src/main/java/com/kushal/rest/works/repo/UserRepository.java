package com.kushal.rest.works.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kushal.rest.works.beans.User;

@Repository
public interface UserRepository extends MongoRepository<User,Integer>{

	// + if u want customized queries you can write here
	//findByName find through name-> Name
	public List<User> findByName(String name);
}
