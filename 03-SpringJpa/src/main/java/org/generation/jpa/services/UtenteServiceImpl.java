package org.generation.jpa.services;

import java.util.List;
import java.util.Optional;

import org.generation.jpa.entities.Utente;
import org.generation.jpa.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteServiceImpl implements UtenteService {

	//Spring inietta un'istanza di una classe concreta che implementa UtenteRepository
	@Autowired
	UtenteRepository utenteRepository; // = new SimpleJpaRepository<Utente, Long>();
	
	@Override
	public List<Utente> prendiTutti() {
		List<Utente> utenti= utenteRepository.findAll(); //=getAll
		for (Utente utente : utenti) {
			utente.setCognome(utente.getCognome().toUpperCase());
			utente.setPassword("**************");
		}
		return utenti;
	}

	@Override
	public Utente cercaPerId(long id) {
		Optional<Utente> optional = utenteRepository.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}else
		{
			return null;			
		}		
		
	}

	@Override
	public void aggiungi(Utente utente) {
		//save vuole una entità (non un dto)
		utenteRepository.save(utente);		
	}

}
