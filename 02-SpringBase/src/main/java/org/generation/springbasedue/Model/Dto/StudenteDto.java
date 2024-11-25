package org.generation.springbasedue.Model.Dto;

import java.util.ArrayList;
import java.util.List;

public class StudenteDto {

	private int id; 
	private String nome;
	private String cognome;
	private List<CorsoDto> corsi;
	
	public StudenteDto() {
		corsi = new ArrayList<CorsoDto>();
		nome = "";
		cognome = "";
	}
	
	public StudenteDto(int id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		corsi = new ArrayList<CorsoDto>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void aggiungiCorso(CorsoDto corso)
	{
		this.corsi.add(corso);
	}

	public List<CorsoDto> getCorsi() {
		return corsi;
	}
	
	
	
	
}
