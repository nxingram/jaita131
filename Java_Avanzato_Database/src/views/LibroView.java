package views;

import java.util.List;

import model.LibroEntity;

public class LibroView {


	public void stampaLibri(List<LibroEntity> libri) {
		for (LibroEntity libro : libri) {
			System.out.println(libro);
		}
		
	}

	public void stampaLibri(LibroEntity libro) {
		System.out.println(libro);		
	}

	
}
