package com.kushal.rest.works.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.kushal.rest.works.beans.User;
import com.kushal.rest.works.repo.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoConfig {
	
	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepo) {
		//return string -> userRepo.insert(new User(101,"kushal",234,"kushal@gmail.com"));
		return null;
	}
	
	
	
}
