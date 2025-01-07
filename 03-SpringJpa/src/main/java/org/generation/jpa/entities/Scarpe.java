package org.generation.jpa.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "scarpe")
public class Scarpe {

	@Id
	private String modelloId;
	
	private String colore;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "scarpe")
	private List<Utente> utenti;


	public String getModelloId() {
		return modelloId;
	}


	public void setModelloId(String modelloId) {
		this.modelloId = modelloId;
	}


	public String getColore() {
		return colore;
	}


	public void setColore(String colore) {
		this.colore = colore;
	}


	public List<Utente> getUtenti() {
		return utenti;
	}


	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}
	
	
	
}
