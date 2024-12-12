package org.generation.jpa.restctrl;

import java.util.List;

import org.generation.jpa.entities.Utente;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/utente")
public class UtenteCtrl {

	/**
	 * IOC - Dependency injection
	 * inversion of control - la dependency injection è un tipo di ioc
	 * invece che creare io a mano le classi che mi servono con il costruttore
	 * es UtenteService  utenteService = new UtenteServiceImpl() 
	 * lo fa Spring
	 */
	@Autowired
	UtenteService utenteService;
	
	/**
	 * ResponseEntity è una classe wrapper che può contenere sia dati
	 * sia lo statuscode (200, 404, 500...)
	 */
	@GetMapping
	public ResponseEntity<List<Utente>> getAll()
	{
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
