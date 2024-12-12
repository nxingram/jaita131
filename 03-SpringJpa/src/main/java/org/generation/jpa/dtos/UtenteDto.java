package org.generation.jpa.dtos;

import java.math.BigDecimal;



public class UtenteDto {

	private long id;
	private String nome;	
	private String cognome;	
	private int eta;		
	private String email;
	private BigDecimal stipendio;
	
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
	
	
}
