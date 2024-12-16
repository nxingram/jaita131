package org.generation.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "macchine")
public class Macchina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 50)
	private String marca;
	@Column(length = 50)
	private String modello;
	@Column(length = 50, unique = true)
	private String targa;
	
	//relazione bidirezionale: in java se cerco una macchina e poi richiamo getUtente,
	// hibernate recupera in automatico i dati dell'utente
	// stessa cosa vale al contrario per l'utente
	// se scrivo in java utente.getMacchine() mi restituisce le macchine associate all'utente
	@JsonIgnore
	@ManyToOne 
	@JoinColumn(name = "utente_id", nullable = false) //name è il nome della chiave esterna presente nella tabella macchine
	private Utente utente;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	
}
