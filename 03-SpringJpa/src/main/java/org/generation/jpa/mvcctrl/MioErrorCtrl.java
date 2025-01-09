package org.generation.jpa.mvcctrl;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MioErrorCtrl  implements ErrorController{

	//Versione 1
		//non serve il controller,
		//basta aggiungere ad "application.properties"
		//server.error.whitelabel.enabled=false
		//e creare una pagina "error.html" che viene trovata automaticamente

//		//@Controller MVC
//		//Versione 2
//	    @RequestMapping("/error")
//	    public String handleError() {
//	        //do something like logging
//	        return "error";
//	    }
	    
	    //@Controller MVC
	    //Versione 3: con "Status Code" errore    
	

	@RequestMapping("/error") 
	public String gestisciErrore(HttpServletRequest request) {
		
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null)
		{
			int statusCode = Integer.valueOf(status.toString());
			
			if(statusCode == HttpStatus.NOT_FOUND.value())
			{
				return "/errori/error-404";
			}
		}
		
		
		return "/error";
	}
}
