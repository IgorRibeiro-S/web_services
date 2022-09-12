package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ScheduleDto;
import com.example.demo.entities.Schedule;
import com.example.demo.repositories.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository repository;

	public List<Schedule> findAll() {
		return repository.findAll();
	}

	public Schedule findById(Long id) {
		Optional<Schedule> obj = repository.findById(id);
		return obj.get();
	}
	public Schedule insertSchedule(Schedule obj) {
		Schedule sche = repository.save(obj);
		return sche;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Schedule update(Schedule obj) {
		Schedule newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
		
	}

	private void updateData(Schedule newObj, Schedule obj) {
		newObj.setCep(obj.getCep());
		newObj.setCidade(obj.getCidade());
		newObj.setEndereco(obj.getEndereco());
		newObj.setEstado(obj.getEstado());
		newObj.setHorario(obj.getHorario());
	}	

	public Schedule fromDto(ScheduleDto objDto) {
		return new Schedule(objDto.getId(), objDto.getHorario(), objDto.getEndereco(), objDto.getCidade(),
				objDto.getCep(), objDto.getEstado(), objDto.getCalled());
	}
}
