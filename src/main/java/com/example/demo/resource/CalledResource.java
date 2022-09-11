package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Called;
import com.example.demo.services.CalledService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@ApiOperation(value = "Mostra lista")
@Api(value="calleds")
@RequestMapping(value = "/calleds")
public class CalledResource {

	@Autowired
	private CalledService service;
	
	
	@GetMapping
	public ResponseEntity<List<Called>> findAll() {
		List<Called> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Called> findById(@PathVariable Long id){
		Called user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
