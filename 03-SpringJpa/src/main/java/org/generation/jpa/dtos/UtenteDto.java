package org.generation.jpa.dtos;

import java.math.BigDecimal;
import java.util.List;

import org.generation.jpa.entities.Iscrizione;
import org.generation.jpa.entities.Macchina;

import jakarta.persistence.OneToMany;



public class UtenteDto {

	private long id;
	private String nome;	
	private String cognome;	
	private int eta;		
	private String email;
	private BigDecimal stipendio;
	private List<Macchina> macchine;
	private List<Iscrizione> iscrizioni;
	

	
	public UtenteDto() {
	}
	
	public UtenteDto(long id, String nome, String cognome, int eta, String email, 
			BigDecimal stipendio) {
	
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.email = email;
		this.stipendio = stipendio;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getStipendio() {
		return stipendio;
	}
	public void setStipendio(BigDecimal stipendio) {
		this.stipendio = stipendio;
	}

	public List<Macchina> getMacchine() {
		return macchine;
	}

	public void setMacchine(List<Macchina> macchine) {
		this.macchine = macchine;
	}

	public List<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}

	public void setIscrizioni(List<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
	
	
}
