package org.generation.jpa.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti_passaporto")
public class UtentePassaporto {

	@Id
	@Column(name = "utente_id")
	private long utenteId;
	
	@Column(length = 20)
	private String numero;
	
	private LocalDate inizioValidita;
	private LocalDate fineValidita;
	
	@JsonIgnore
	@OneToOne
	@MapsId //indica cha la chiave primaria verrà copiata dall'entità utente
	@JoinColumn(name = "utente_id")
	private Utente utente;
	
	

	public long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(long utenteId) {
		this.utenteId = utenteId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getInizioValidita() {
		return inizioValidita;
	}

	public void setInizioValidita(LocalDate inizioValidita) {
		this.inizioValidita = inizioValidita;
	}

	public LocalDate getFineValidita() {
		return fineValidita;
	}

	public void setFineValidita(LocalDate fineValidita) {
		this.fineValidita = fineValidita;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
	
	
	
	
}
