package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.AcessType;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "teste@1234.com", "123", null, AcessType.ADMIN);
		User u2 = new User(null, "sdsds@1234.com", "555", null, AcessType.SUPPORT);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	

}
