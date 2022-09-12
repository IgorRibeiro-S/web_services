package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CalledDto;
import com.example.demo.entities.Called;
import com.example.demo.repositories.CalledRepository;

import io.swagger.annotations.ApiOperation;

@Service
@ApiOperation(value = "Mostra lista")
public class CalledService {

	@Autowired
	private CalledRepository repository;

	public List<Called> findAll() {
		return repository.findAll();
	}

	public Called findById(Long id) {
		Optional<Called> obj = repository.findById(id);
		return obj.get();
	}
	
	public Called insertCalled(Called obj) {
		Called prod = repository.save(obj);
		return prod;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Called update(Called obj) {
		Called newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}

	private void updateData(Called newObj, Called obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setImgUrl(obj.getImgUrl());
		newObj.setProduct(obj.getProduct());
	}

	public Called fromDto(CalledDto objDto) {
		return new Called(objDto.getId(), objDto.getTitulo(), objDto.getDescricao(), objDto.getImgUrl(),
				objDto.getDataChamado(), objDto.getUser(), objDto.getProduct());

	}
}
