package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserCorpClient;
import com.example.demo.services.UserCorpClientService;

@RestController
@RequestMapping(value = "/UserCorp")
public class UserCorpClientResource {

	@Autowired
	private UserCorpClientService service;
	
	@GetMapping
	public ResponseEntity<List<UserCorpClient>> findAll() {
		List<UserCorpClient> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<UserCorpClient> findById(@PathVariable Long id){
		UserCorpClient user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

}