package com.ab.abcontato.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ab.abcontato.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	List<Contato> findAllByOrderByNomeAsc();
}
