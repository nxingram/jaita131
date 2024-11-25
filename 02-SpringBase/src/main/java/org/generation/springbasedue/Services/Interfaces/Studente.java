package org.generation.springbasedue.Services.Interfaces;

import java.util.List;

import org.generation.springbasedue.Model.Dto.StudenteDto;

public interface Studente extends CommonService<StudenteDto> {

	String UNA_COSTANTE = "DUE";
	
	//List<StudenteDto> getTutti();
	//StudenteDto getUnoPerId(int idStudente);
	
	StudenteDto aggiungiStudente(StudenteDto s);
}
