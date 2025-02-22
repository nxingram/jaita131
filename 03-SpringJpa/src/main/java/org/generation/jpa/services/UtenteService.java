package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.Utente;
import org.springframework.data.domain.Pageable;

public interface UtenteService {

	public List<Utente> prendiTutti();
	public List<UtenteDto> prendiTuttiDto();
	public List<UtenteDto> prendiTuttiDtoPaging(Pageable pageable);

	public Utente cercaPerId(long id);

	public UtenteDto aggiungi(Utente utente);
	public UtenteDto aggiornaUtente(Utente utente, Utente trovato);
	public void cancellaUtente(long id);
	public Utente cercaPerEmail(String email);
}
