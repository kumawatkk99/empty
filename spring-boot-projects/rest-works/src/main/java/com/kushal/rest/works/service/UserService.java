package com.kushal.rest.works.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kushal.rest.works.beans.User;
import com.kushal.rest.works.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.insert(user);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public Optional<User> getUserById(Integer id) {
		return userRepo.findById(id);
	}
	
	public User getUserByIdAsObject(Integer id) {
		Optional<User> byId=userRepo.findById(id);
		if(byId.isPresent()) {
			return byId.get();
		}
		return null;
	}
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public List<User> getUserByName(String name){
		return userRepo.findByName(name);
	}
	
	public void deleteUser(Integer Id) {
		userRepo.deleteById(Id);
	}
	
	
	
	
}
