package org.generation.jpa.services;

import java.util.List;

import org.generation.jpa.entities.Utente;

public interface UtenteService {

	public List<Utente> prendiTutti();

	public Utente cercaPerId(long id);

	public void aggiungi(Utente utente);
}
