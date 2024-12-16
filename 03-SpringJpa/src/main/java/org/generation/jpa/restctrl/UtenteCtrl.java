package org.generation.jpa.restctrl;

import java.util.ArrayList;
import java.util.List;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.Utente;
import org.generation.jpa.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	UtenteService utenteService; // = = new UtenteServiceImpl() 
	
	/**
	 * ResponseEntity è una classe wrapper che può contenere sia dati
	 * sia lo statuscode (200, 404, 500...)
	 */
	@GetMapping
	public ResponseEntity<List<UtenteDto>> getAll()
	//public ResponseEntity<?> getAll() //? = generici tipo jolly
	{
		try {
//			List<Utente> utenti = utenteService.prendiTutti();
			//modo 1 per restituire i dati nel body e lo statusCode
			//return new ResponseEntity<List<Utente>>(utenti, HttpStatus.OK);
			//modo2, stessa cosa
//			return ResponseEntity.ok(utenti);
			
			List<UtenteDto> utentiDto = utenteService.prendiTuttiDto();
			return ResponseEntity.ok(utentiDto);
			
		} catch (Exception e) {
			//return ResponseEntity.internalServerError().build();
			return ResponseEntity.internalServerError().body(new ArrayList<UtenteDto>());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utente> getOneById(@PathVariable("id") long id)
	{
		try {
			Utente u = utenteService.cercaPerId(id);
			if(u != null)
			{
				return ResponseEntity.ok(u); //200				
			}else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Utente());
			}
			
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Utente());
		}
	}
	
	
	@PostMapping
//	public ResponseEntity<Utente> addOne(@RequestBody Utente utente)
	public ResponseEntity<?> addOne(@RequestBody Utente utente)
	{
		try {			
			//funziona per riferimento:
			//l'utente arriva dal client senza id
			//viene passato al service e poi al repository
			//quando viene persistito/salvato mysql mette un id
			// e me lo ritrovo valorizzato nell'oggetto
			UtenteDto dto = utenteService.aggiungi(utente); 
			

			return ResponseEntity.ok(dto); //200	
			
		}catch (DataIntegrityViolationException e)
		{
			return ResponseEntity.badRequest().body("Errore inserimento dati, controllare le proprietà dell'oggetto");
		}
		catch (Exception e) {
			return ResponseEntity.internalServerError().body(new Utente());
		}
	}
	
	
	
	
	
	
	
}
