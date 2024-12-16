package org.generation.jpa.mvcctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //MVC
public class HtmlCtrl {
/*
 * Voglio usare un controller mvc per intercettare le richieste path url
 * e restituire una pagina html (NON json)
 * 
 */
	/**
	 * Mapping mia home page
	 */
	@GetMapping("/")
	public String miaHome() {
		return "MiaHomepage"; //restituisce MiaHomepage.html
	}
	
	@GetMapping("/swagger")
	public String swagger() {
		/*
		 * redirect: indica la browser di rifare una request all'indirizzo indicato
		 * 
		 * restituisce 302 (reindirizzamento url)
		 */
		return "redirect:/swagger-ui/index.html#"; //reindirizzo alla libreria swagger la richiesta
	}
	
	@GetMapping("/utenti")
	public String utentiPage() {
		return "Utenti";  //Utenti.html
		
	}
	
}
