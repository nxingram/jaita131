package org.generation.springbasedue.Services;

import java.util.ArrayList;
import java.util.List;

import org.generation.springbasedue.Model.Dto.CorsoDto;
import org.generation.springbasedue.Model.Dto.StudenteDto;
import org.generation.springbasedue.Services.Interfaces.Studente;
import org.springframework.stereotype.Service;

/**
 * Questo layer/strato si occupa della logica Business,
 * cioè tutto il codice (o quasi)dell'applicazione che riguarda le operazioni sugli studenti
 * 
 * perché si fa così?
 * perchè così posso riutilizzare questi metodi per molteplici controllers
 * 
 * @Service indica che questa classe appartiene allo strato dei servizi e contiene la 
 * logica Business
 * 
 * StudenteImpl implements Studenti
 */
@Service
public class StudenteSrv implements Studente {

	private List<StudenteDto> studenti;
	private static int id = 0;
	
	public StudenteSrv() {
		studenti = new ArrayList<StudenteDto>(); //inizilizzo la collezione
		this.caricaStudentiECorsi();
	}

//	public List<StudenteDto> getTutti() {		
//		return studenti;
//	}

	@Override
	public List getTutti() {
		return studenti;
	}
	
	public StudenteDto getUnoPerId(int idStudente) {

		for (StudenteDto s : studenti) {
			if(s.getId() == idStudente)
			{
				return s;
			}
		}
		
		return new StudenteDto();
	}
	
	/**
	 * Metodo ausiliario: private ed è utilizzabile solo da questa classe
	 */
	private void caricaStudentiECorsi() {
		CorsoDto c1 = new CorsoDto(1,"Java");
		CorsoDto c2 = new CorsoDto(2,"Javascript");
		CorsoDto c3 = new CorsoDto(3,"Database");
		CorsoDto c4 = new CorsoDto(4,"HTML");
		
		StudenteDto s1 = new StudenteDto(++id, "Enrico", "Cairo");
		s1.aggiungiCorso(c1);
		s1.aggiungiCorso(c2);
		s1.aggiungiCorso(c3);		
		studenti.add(s1);
		
		StudenteDto s2 = new StudenteDto(++id, "Franco", "Baresi");
		s2.aggiungiCorso(c4);
		s2.aggiungiCorso(c2);
		studenti.add(s2);		
		
	}
	
	public void altroMetodo() {
		System.out.println("non fa nulla");
	}
	
	public StudenteDto aggiungiStudente(StudenteDto s)
	{
		//assegno l'id allo studente
		s.setId(++id);	
		studenti.add(s);
		return s;
	}


}
