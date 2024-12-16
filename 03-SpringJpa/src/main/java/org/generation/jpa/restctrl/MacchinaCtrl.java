package org.generation.jpa.restctrl;

import org.generation.jpa.entities.Macchina;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/macchina")
public class MacchinaCtrl {

	@PostMapping("/utente/{id}") //id utente
	public void aggiungiMacchina(@RequestBody Macchina macchina, @PathVariable("id") long id)
	{
		
	}
}
