package org.generation.springbasedue.Model.Dto;

import java.util.ArrayList;
import java.util.List;

public class DocenteDto {
    private int id;
    private String nome;
    private String cognome;
    private String materia;
    private List<CorsoDto> corsi;

    public DocenteDto() {
        corsi = new ArrayList<CorsoDto>();
    }

    public DocenteDto(int id, String nome, String cognome, String materia) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
        this.corsi = new ArrayList<CorsoDto>();
    }


    // Getters and Setters
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
    public List<CorsoDto> getCorsi() {
        return corsi;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void addCorso(CorsoDto corso) {
        corsi.add(corso);
    }

}

