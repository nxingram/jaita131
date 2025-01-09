package org.generation.jpa.mvcctrl;

import java.util.List;
import java.util.Optional;

import org.generation.jpa.entities.Corso;
import org.generation.jpa.services.CorsoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//MVC e REST: https://github.com/nxingram/spring-boot-java/tree/main/Spring-Boot-Tutorial-base
//Thymeleaf: https://www.thymeleaf.org/documentation.html

@Controller
@RequestMapping("/corsi")
public class CorsoCtrl {

	@Autowired
	CorsoServiceImpl corsoService;
	
	@GetMapping
	public String findAll(Model model) //String xè restituisce una pagina text/html
	{
		List<Corso> corsi =  corsoService.findAll();
		
		model.addAttribute("listaCorsi", corsi);
		model.addAttribute("titolo", "Elenco Corsi");
		
		//pagina thymleaf nella cartella templates
		//prende i dati contenuti in "model" e li visualizza nell'html
		return "elenco-corsi";			
	}
	
	@GetMapping("/corso-add-update-form")
	public String addCorsoForm(Model model) {
		try {
			//passo alla view un oggetto corso vuoto da popolare
			model.addAttribute("corso", new Corso()); 
			
			model.addAttribute("titolo", "Aggiungi Corso");
			
			return "corso-add-update-form";
			
		} catch (Exception e) {
			//pagina di errore che dovrei mettere in ogni metodo
//			model.addAttribute("errore", e);
//			return "pagina-errore";
			//oppure creo una pagina standard error.html
			//questa pagina funziona sempre, anche se l'errore avviene in un metodo REST o altro MVC
			//funziona per tutto il progetto
			return "error";
		}
		
	}
	
	@PostMapping("/salva")
	//con RequestParam se ne ho pochi... ok, altrimenti scrivo troppo codice
//	public String salva(@RequestParam("titolo") String titolo, @RequestParam("descrizione") String descrizione) {
	//viene creato in automatico un oggetto corso popolato con i parametri della request
	public String salva(Corso corso) { 
		
		corsoService.save(corso);
		
		return "redirect:/corsi";	
	}
	
	
	@GetMapping("/{id}") //modifica
	public String modifica(@PathVariable("id") long id, Model model)
	{
		 Optional<Corso> opt = corsoService.findById(id);
		
		if(opt.isPresent())
		{
			model.addAttribute("corso", opt.get()); 			
			return "corso-add-update-form";
		}
		
		return "redirect:/corsi";	
	}
	
	@GetMapping("/delete/{id}") //cancella
	public String cancella(@PathVariable("id") long id)
	{
		Optional<Corso> opt = corsoService.findById(id);
		if(opt.isPresent())
		{
			corsoService.delete(opt.get());
		}
		
		return "redirect:/corsi";	
	}
	
	
	
}
