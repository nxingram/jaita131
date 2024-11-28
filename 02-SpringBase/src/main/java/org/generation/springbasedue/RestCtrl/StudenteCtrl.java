package org.generation.springbasedue.RestCtrl;

import java.util.ArrayList;
import java.util.List;

import org.generation.springbasedue.Model.Dto.StudenteDto;
import org.generation.springbasedue.Services.Interfaces.CommonService;
import org.generation.springbasedue.Services.Interfaces.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 * path: api/studente + PUT
	 */
	@PutMapping
	public StudenteDto updateOne(@RequestBody StudenteDto studente)
	{
		StudenteDto trovato =  srv.getUnoPerId(studente.getId());
		if(trovato.getId() == 0)
		{
			//non ho trovato lo studente da modificare, restitusco il json della request	
			return studente;	
		}
		
		return srv.modificaStudente(studente);
	}
	
	/**
	 * Cancella 1
	 * path: api/studente/2 + DELETE
	 */
	@DeleteMapping("/{id}")
	public int deleteOne(@PathVariable("id") int id)
	{
		StudenteDto trovato = srv.getUnoPerId(id);
		//se non trova lo studente da cancellare
		if(trovato.getId() == 0 )
		{
			return 0;
		}
		
		srv.cancellaUnostudente(id);
		return 1;
	}
	
	/**
	 * Cancella tutti
	 * path: api/studente + DELETE
	 */
	@DeleteMapping
	public List<StudenteDto> deleteTutti()
	{
		return srv.cancellaTutti();
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
