package controllers;

import java.sql.Connection;
import java.util.List;

import dal.ConnessioneDatabase;
import dal.LibroDaoImpl;
import model.LibroEntity;
import views.LibroView;

public class ProvaDatabase {

	//Simuliamo una struttura di tipo MVC: model-view-controller
	//mvc è un design pattern (come anche REST:api json)
	//che restituisce html.
	//la view è l'interfaccia utente (html o console)
	//view e controller in questo caso coincidono
	//model (entità) sarebbero i dati presenti su un database
	public static void main(String[] args) {
		
		LibroDaoImpl libroDao = new LibroDaoImpl();
		//libroDao.readLibro(); metodo esempio
		
		//tutti i libri
		List<LibroEntity> libri = libroDao.getAll();
		
		LibroView lv = new LibroView();
		lv.stampaLibri(libri);
		
		//un libro per id
		LibroEntity libro = libroDao.getLibroById(4);
		
		//Polimorfismo di compilazione: ho 2 metodi con lo stesso nome
		//che accettano un parametro differente
		//noi lo conosciamo come overloading del metodo
		lv.stampaLibri(libro);
		
		
		libro = libroDao.getLibroById(5);
		lv.stampaLibri(libro);
		
		/*
		ConnessioneDatabase db = new ConnessioneDatabase(); //istanza
		Connection conn = db.getConnection();
		
		
		ConnessioneDatabase db2 = new ConnessioneDatabase(); //istanza
		Connection conn2 =  db2.getConnection();
		
		//Connection conn3 = ConnessioneDatabase.conn;
		//Math.random();
		
		db.closeConnection();
		
		ConnessioneDatabase db3 = new ConnessioneDatabase(); //istanza
		Connection conn3 =  db3.getConnection();
		
		db.closeConnection();
		*/
	}

}
