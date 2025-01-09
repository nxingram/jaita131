package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.entities.Corso;
import org.generation.jpa.repositories.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorsoServiceImpl {

	@Autowired
	CorsoRepository corsoRepo;

	public List<Corso> findAll() {
		return corsoRepo.findAll();
	}
	
	
}
