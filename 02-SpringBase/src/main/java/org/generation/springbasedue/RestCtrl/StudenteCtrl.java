package org.generation.springbasedue.RestCtrl;

import java.util.List;

import org.generation.springbasedue.Model.Dto.StudenteDto;
import org.generation.springbasedue.Services.Interfaces.CommonService;
import org.generation.springbasedue.Services.Interfaces.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/studente") //path/mappatura radice
public class StudenteCtrl {

	/*
	 * Dependency Injection - Inversion of Control
	 * 
	 * Inversion of Control:
	 * le classi invece che instanziarle io, vogli che le crei e gestisca Spring
	 * 
	 * Dependency Injection:
	 * è il framework che determina (su nostra indicazione) quali dipendenze iniettare (aggiungere o inserire)
	 * nella nostra classe
	 * 
	 * @@Autowired:
	 * inietta la dipendenza nella classe, cioè crea l'istanza e la assegna alla variabile
	 * StudenteSrv srv = new StudenteSrv(); //istanza
	 * 
	 * Dipende == ha bisogno di un'istanza (la inizializza)
	 */
	@Autowired
	private Studente srv;
	//private CommonService<StudenteDto> srv; //alternativa ancora più generica
	
	/*
	 * Stessa cosa ma con un costruttore
	 */
//	@Autowired
//	public StudenteCtrl(StudenteSrv srv) {
//		this.srv = srv;
//	}
	
	
	/**
	 * path: /studente +GET
	 * @return lista di studenti
	 */
	@GetMapping
	public List<StudenteDto> getAll(){	
		
		//Non fate così, è solo un esempio
		//StudenteSrv srv = new StudenteSrv(); //istanza
		return srv.getTutti();			
	
	}
	
	/**
	 * {id}: segnaposto
	 * path: /api/studente/2
	 * 
	 * @PathVariable("id"):
	 * prende il valore presente nell'url e lo assegna alla variabile idStudente
	 * 
	 * @return StudenteDto
	 */
	@GetMapping("/{id}")
	public StudenteDto getById(@PathVariable("id") int idStudente)
	{
		return srv.getUnoPerId(idStudente);
	}
	
	/**
	 * rotta: api/studente + POST
	 */
	//@PostMapping
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudenteDto addOne(@RequestBody StudenteDto studente)
	{
		srv.aggiungiStudente(studente);
		return studente;		
	}
	
	/**
	 * path: /api/studente/querystring?nome=ciccio&cognome=pasticcio
	 */
	@PostMapping("querystring")
	public StudenteDto addOneQueryString(
			@RequestParam("nome") String nome, 
			@RequestParam("cognome") String cognome
			)
	{
		StudenteDto s = new StudenteDto();
		s.setNome(nome);
		s.setCognome(cognome);
		
		//lo dovrei salvare
		return s;		
	}
	
	
}
