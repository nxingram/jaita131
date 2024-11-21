package org.generation.__SpringBase.models.dtos;

import java.util.ArrayList;

/**
 * Design patterns:
 * Dto: data tranfer Objet
 * è un oggetto per trasferire dei dati
 * 
 * Dto = modello + trasferimento dati
 * 
 * Model: modello di rappresentazione di un oggetto, cioè una Classe
 * 
 * Cos'è una Classe?
 * è un modello di un oggetto (modellino)
 */
public class Studente {

	private int id;
	private String nome;
	private String cognome;	
	
	private ArrayList<String> corsi;	
	
	public Studente() {
	}

	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}		
	
	public Studente(int id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<String> getCorsi() {
		return corsi;
	}



	public void setCorsi(ArrayList<String> corsi) {
		this.corsi = corsi;
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
	
	
	
}
