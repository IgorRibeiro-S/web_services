package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CalledDto;
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

	@PostMapping
	public ResponseEntity<Called> insert(@RequestBody CalledDto obj) {
		Called p = service.fromDto(obj);
		p = service.insertCalled(p);
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Called> update(@PathVariable Long id, @RequestBody CalledDto obj) {
		Called p = service.fromDto(obj);
		obj.setId(id);
		p = service.update(p);
		return ResponseEntity.noContent().build();
	}

}
