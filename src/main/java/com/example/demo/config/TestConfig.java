package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.AcessType;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.entities.UserCommonClient;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserCommonClientRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserCommonClientRepository userCommonClientRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "teste@1234.com", "123", null, AcessType.ADMIN);
		User u2 = new User(null, "sdsds@1234.com", "555", null, AcessType.SUPPORT);
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		UserCommonClient usCommon = new UserCommonClient(null,"Douglas", "11111", "douglas@gmail.com","997878787", AcessType.CLIENT);

		
		userCommonClientRepository.saveAll(Arrays.asList(usCommon));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		
		
	}
	

}
