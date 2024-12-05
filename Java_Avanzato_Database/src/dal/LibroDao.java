package dal;

import java.util.List;

import model.LibroEntity;

public interface LibroDao {

	//Questa è la query da eseguire nel metodo getAll
	String SELECT_ALL = "Select * from libro";
	//mancano le altre query
	
	//CRUD
	List<LibroEntity> getAll(); //read
	LibroEntity getLibroById(int id); //read one
	int updateLibro(LibroEntity libro); //update
	int deleteLibroById(int id); //delete
}
