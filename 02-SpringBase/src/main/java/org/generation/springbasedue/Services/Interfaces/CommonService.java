package org.generation.springbasedue.Services.Interfaces;

import java.util.List;

import org.generation.springbasedue.Model.Dto.StudenteDto;

public interface CommonService<T> {

	List<T> getTutti();
	T getUnoPerId(int id);
}
