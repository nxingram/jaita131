package org.generation.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.generation.jpa.dtos.UtenteDto;
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
	public List<UtenteDto> prendiTuttiDto() {
		List<Utente> utenti= utenteRepository.findAll();
		return this.toUtenteDto(utenti);
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
	public UtenteDto aggiungi(Utente utente) {
		//save vuole una entità (non un dto)
		utenteRepository.save(utente);		
		
		return this.toUtenteDto(utente);

	}
	
	private List<UtenteDto> toUtenteDto(List<Utente> utenti)
	{
		List<UtenteDto> utentiDto = new ArrayList<UtenteDto>();
		for (Utente utente : utenti) {
			utentiDto.add(this.toUtenteDto(utente));
		}
		return utentiDto;
	}
	
	private UtenteDto toUtenteDto(Utente utente)
	{
		UtenteDto dto = new UtenteDto(
		utente.getId(),
		utente.getNome(),
		utente.getCognome(),
		utente.getEta(),
		utente.getEmail(),
		utente.getStipendio()
		);
		
		return dto;
	}

	@Override
	public UtenteDto aggiornaUtente(Utente utente, Utente trovato) {
		trovato.setNome(utente.getNome());
		trovato.setCognome(utente.getCognome());
		trovato.setEta(utente.getEta());
		trovato.setEmail(utente.getEmail());
		
		//Save: sia insert sia update
		//il primo non ha l'id, il secondo ha l'id
		utenteRepository.save(trovato);
		
		return this.toUtenteDto(utente);
	}

	@Override
	public void cancellaUtente(long id) {
		// TODO Auto-generated method stub
		utenteRepository.deleteById(id);;
	}

	@Override
	public Utente cercaPerEmail(String email) {
//		return utenteRepository.findByEmail(email);		
//		return utenteRepository.trovaPerEmail(email);		
		return utenteRepository.trovaPerEmailNativo(email);		
	}



}
