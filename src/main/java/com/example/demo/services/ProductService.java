package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductDto;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

	public Product insertProduct(Product obj) {
		Product prod = repository.save(obj);
		return prod;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Product update(Product obj) {
		Product newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}

	private void updateData(Product newObj, Product obj) {
		newObj.setModelo(obj.getModelo());
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setDescricao(obj.getDescricao());
		newObj.setNumeroDeSerie(obj.getNumeroDeSerie());
		
	}

	public Product fromDto(ProductDto objDto) {
		return new Product(objDto.getId(), objDto.getModelo(), objDto.getNumeroDeSerie(), objDto.getDescricao(),
				objDto.getDataFabricacao(), objDto.getDataCadastro(), objDto.getUser());
	}
}
