package org.jaita131.helloworld.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello") //Percorso/Rotta o azione del controller
public class HelloController {

	//Di default restituisce un file json (content-type:application/json)
	@GetMapping
	public ArrayList<String> getAll(){		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Ciao Paolo");
		lista.add("Ciao Gemma");
		return lista;
	}
}
