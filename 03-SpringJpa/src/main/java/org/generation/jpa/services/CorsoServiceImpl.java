package org.generation.jpa.services;

import java.util.List;
import java.util.Optional;

import org.generation.jpa.entities.Corso;
import org.generation.jpa.repositories.CorsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CorsoServiceImpl {

	@Autowired
	CorsoRepository corsoRepo;
	@Autowired
	UtenteService utenteservice;
	
	public List<Corso> findAll() {
		return corsoRepo.findAll();
	}

	//@Transactional in automatico inietta nel nostro codice un try-catch
	// e catcha tutte le eccezioni di tipo "rollbackFor"
	//isolamento: usato quando ho una transazione all'interno di un'altra transazione
	//es: qunado un metodo service richiama un altro metodo service annotato con Transactional
	@Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void save(Corso corso) {
		//potrei anche modificare i dati dell'iscrizione
		//se una di queste operazioni non va a buon fine è importante fare un rollback delle operazioni
		corsoRepo.save(corso);	
		
		//corso = null;
		//corso.getTitolo(); //null pointer exception e fare il rollback del salvataggio del corso
	}//commit se non ci sono eccezioni

	public Optional<Corso> findById(long id) {
		return corsoRepo.findById(id);
	}

	public void delete(Corso corso) {
		corsoRepo.delete(corso);		
	}
	
	
}
