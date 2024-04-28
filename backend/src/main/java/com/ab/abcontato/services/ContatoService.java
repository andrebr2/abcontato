package com.ab.abcontato.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ab.abcontato.dto.ContatoDTO;
import com.ab.abcontato.entities.Contato;
import com.ab.abcontato.repositories.ContatoRepository;
import com.ab.abcontato.services.exceptions.ResourceNotFoundException;

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
	
	@Transactional(readOnly=true)
	public ContatoDTO findById(Long id) {
		Optional<Contato> obj = repository.findById(id);
		Contato entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
		return new ContatoDTO(entity);
	}
	
}
