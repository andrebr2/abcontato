package com.ab.abcontato.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.abcontato.dto.ContatoDTO;
import com.ab.abcontato.entities.Contato;
import com.ab.abcontato.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	@Transactional(readOnly=true)
	public List<ContatoDTO> findAll() {
		
		List<Contato> list = repository.findAllByOrderByNomeAsc();
		return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ContatoDTO insert(ContatoDTO dto) {
		Contato contato = new Contato(null, dto.getNome(), dto.getSobrenome(), dto.getTelefone());
		contato = repository.save(contato);
		return new ContatoDTO(contato);
	}
	
}
