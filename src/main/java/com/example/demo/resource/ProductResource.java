package com.example.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}
	@GetMapping(value ="/{id}" )
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody ProductDto obj){
		Product p = service.FromDto(obj);
		p = service.insertProduct(p);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}

}
