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

import com.example.demo.dtos.ScheduleDto;
import com.example.demo.entities.Schedule;
import com.example.demo.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {

	@Autowired
	private ScheduleService service;
	
	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Schedule> findById(@PathVariable Long id){
		Schedule schedule = service.findById(id);
		return ResponseEntity.ok().body(schedule);
	}
	@PostMapping
	public ResponseEntity<Schedule> insert(@RequestBody ScheduleDto obj) {
		Schedule sche = service.fromDto(obj);
		sche = service.insertSchedule(sche);
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
	public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody ScheduleDto obj) {
		Schedule object = service.fromDto(obj);
		object.setId(id);
		object = service.update(object);
		return ResponseEntity.noContent().build();
	}

}
