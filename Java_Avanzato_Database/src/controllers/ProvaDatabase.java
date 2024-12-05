package controllers;

import java.sql.Connection;

import dal.ConnessioneDatabase;
import dal.LibroDaoImpl;

public class ProvaDatabase {

	//Simuliamo una struttura di tipo MVC: model-view-controller
	//mvc è un design pattern (come anche REST:api json)
	//che restituisce html.
	//la view è l'interfaccia utente (html o console)
	//view e controller in questo caso coincidono
	//model (entità) sarebbero i dati presenti su un database
	public static void main(String[] args) {
		
		LibroDaoImpl libroDao = new LibroDaoImpl();
		libroDao.readLibro();
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
