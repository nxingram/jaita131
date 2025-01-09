package org.generation.jpa.mvcctrl;

import java.util.List;

import org.generation.jpa.entities.Corso;
import org.generation.jpa.services.CorsoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//https://github.com/nxingram/spring-boot-java/tree/main/Spring-Boot-Tutorial-base

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
	
	
}
