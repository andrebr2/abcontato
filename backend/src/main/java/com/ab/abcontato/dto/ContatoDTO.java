package com.ab.abcontato.dto;

import java.io.Serializable;

import com.ab.abcontato.entities.Contato;

public class ContatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String telefone;
	
	public ContatoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ContatoDTO(Long id, String nome, String sobrenome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	public ContatoDTO(Contato entity) {
		id = entity.getId();
		nome = entity.getNome();
		sobrenome = entity.getSobrenome();
		telefone = entity.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
