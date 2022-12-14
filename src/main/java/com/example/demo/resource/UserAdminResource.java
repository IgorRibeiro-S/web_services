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

import com.example.demo.dtos.UserAdminDto;
import com.example.demo.entities.UserAdmin;
import com.example.demo.services.UserAdminService;

@RestController
@RequestMapping(value = "/userAdmin")
public class UserAdminResource {

	@Autowired
	private UserAdminService service;
	
	@GetMapping
	public ResponseEntity<List<UserAdmin>> findAll() {
		List<UserAdmin> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<UserAdmin> findById(@PathVariable Long id){
		UserAdmin user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	@PostMapping
	public ResponseEntity<UserAdmin> insert(@RequestBody UserAdminDto obj) {
		UserAdmin sche = service.fromDto(obj);
		sche = service.insertUserAdmin(sche);
		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return new ResponseEntity<>(sche, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserAdmin> update(@PathVariable Long id, @RequestBody UserAdminDto obj) {
		UserAdmin object = service.fromDto(obj);
		object.setId(id);
		object = service.update(object);
		return ResponseEntity.noContent().build();
	}


}
