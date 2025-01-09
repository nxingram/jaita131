package org.generation.jpa.corsi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.generation.jpa.entities.Corso;
import org.generation.jpa.repositories.CorsoRepository;
import org.generation.jpa.services.CorsoServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CorsoTests {

	//https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
	
	@Autowired
	CorsoRepository corsoRepo;
	
	@Autowired
	CorsoServiceImpl corsoService;
	
	
	@BeforeEach //esegue il codice prima di ogni metodo
	@Transactional
	void loadData() {
		corsoRepo.save(new Corso("prova","prova prova"));
	}
	
	@Test
	@Transactional
	void mioTest() {
		Corso corso = corsoRepo.findByTitolo("Java");
		
		assertEquals("Java", corso.getTitolo());
//		assertEquals("Javas", corso.getTitolo());
		
		assertTrue( corsoRepo.findAll().size() > 0 );
		
		
		assertTrue( corsoService.findById(1L) != null);
		
		assertEquals("prova", corsoRepo.findByTitolo("prova").getTitolo());
	}
	
	@AfterEach
	@Transactional
	void clearData() {
		corsoRepo.delete(corsoRepo.findByTitolo("prova"));
	}
	
}
