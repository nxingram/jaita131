package org.generation.jpa.restctrl;

import java.util.ArrayList;
import java.util.List;

import org.generation.jpa.dtos.UtenteDto;
import org.generation.jpa.entities.Utente;
import org.generation.jpa.services.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;



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
	
	//https://www.geeksforgeeks.org/spring-boot-logging/
	Logger logger = LoggerFactory.getLogger(UtenteCtrl.class);

	
	/**
	 * ResponseEntity è una classe wrapper che può contenere sia dati
	 * sia lo statuscode (200, 404, 500...)
	 */
	@GetMapping
	public ResponseEntity<List<UtenteDto>> getAll()
	//public ResponseEntity<?> getAll() //? = generici tipo jolly
	{
		logger.info("mio log \"info\"");
		
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
	
	@GetMapping("/paging")
	public ResponseEntity<List<UtenteDto>> getAllPaging(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "nome") String sortBy, // Default sorting by name
            @RequestParam(defaultValue = "ASC") String sortDirection			
			)
	{
		
		logger.info("mio log \"info\"");
		logger.warn("mio log \"warn\"");
		logger.error("mio log \"error\"");
		logger.debug("mio log \"debug\"");
		
		try {
			
			Direction direction = sortDirection.equalsIgnoreCase("ASC") ? Direction.ASC : Direction.DESC;
	        Sort sort = Sort.by(direction, sortBy);

	        Pageable pageable = PageRequest.of(page, size, sort);
			
			List<UtenteDto> utentiDto = utenteService.prendiTuttiDtoPaging(pageable);
			return ResponseEntity.ok(utentiDto);
			
		} catch (Exception e) {
			//return ResponseEntity.internalServerError().build();
			logger.error(e.toString());
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
	
	@PutMapping
	public ResponseEntity<?> updateOne(@RequestBody Utente utente)
	{
		try {
			Utente trovato = utenteService.cercaPerId(utente.getId());
			//cerca per email	
			Utente trovatEmail = utenteService.cercaPerEmail(utente.getEmail());
			
			if(trovato != null && trovatEmail.getId() == trovato.getId())
			{
				UtenteDto dto = utenteService.aggiornaUtente(utente, trovato);
				return ResponseEntity.ok(dto); //senza la password
				
			}else if(trovatEmail.getId() != trovato.getId()) {
				//c'è qualcuno nel database con un'email già utilizzata
				//questo è il caso dove l'utente cambia la mail ma c'è già su db
				return ResponseEntity.badRequest().body("Errore email non corretta.");
			}
			else {
				return  ResponseEntity.badRequest().body("Errore utente non trovato");				
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new UtenteDto());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOneByID(@PathVariable("id") long id)
	{
		try {
			Utente trovato = utenteService.cercaPerId(id);
			if(trovato != null)
			{				
				utenteService.cancellaUtente(id);
				return ResponseEntity.ok("Cancellato utente id=" + id); //senza la password
				
			}else {
				return  ResponseEntity.badRequest().body("Errore utente non trovato");				
			}
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(new UtenteDto());
		}
	}
	
	
	@GetMapping("/demorequest")
	public void HttpRequest(HttpServletRequest request, @RequestParam("nome") String paramNome)
	{
		//form html input type text name="nome"
		//nome == paramNome
		String nome = request.getParameter("nome");
		
	}
	
	
	
	
}
