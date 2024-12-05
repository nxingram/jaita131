package dal;

import java.util.List;

import model.LibroEntity;

public interface LibroDao {

	//Questa è la query da eseguire nel metodo getAll
	String SELECT_ALL = "Select * from libro";
	String SELECT_BY_ID = "select * from libro where id = ?";
	String INSERT_LIBRO = "Insert into libro(titolo, prezzo, pagine, id_editore) values(?,?,?,?)";
	
	//CRUD
	List<LibroEntity> getAll(); //read
	LibroEntity getLibroById(int id); //read one
	int updateLibro(LibroEntity libro); //update
	int deleteLibroById(int id); //delete
	int addLibro(LibroEntity libro);//create
	LibroEntity getByTitolo(String string);//read
}
