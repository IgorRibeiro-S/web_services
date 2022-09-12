package com.example.demo.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.example.demo.entities.Called;
import com.example.demo.entities.Schedule;

public class ScheduleDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Instant horario;
	private String endereco;
	private String cidade;
	private String cep;
	private String estado;
	private Called called;
	
	public ScheduleDto() {
	}
	
	public ScheduleDto(Schedule obj) {
		this.id = obj.getId();
		this.horario = obj.getHorario();
		this.endereco = obj.getEndereco();
		this.cidade = obj.getCidade();
		this.cep = obj.getCep();
		this.estado = obj.getEndereco();
		this.called = obj.getCalled();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getHorario() {
		return horario;
	}

	public void setHorario(Instant horario) {
		this.horario = horario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Called getCalled() {
		return called;
	}

	public void setCalled(Called called) {
		this.called = called;
	}
	
}
