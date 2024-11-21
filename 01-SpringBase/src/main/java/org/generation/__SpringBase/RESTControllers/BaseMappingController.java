package org.generation.__SpringBase.RESTControllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.generation.__SpringBase.models.dtos.Studente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/base")
@RequestMapping(path = "/api/base") //sono la stessa cosa
public class BaseMappingController {
 
	//Mappatura: 
	//associazione con un url
	//se mappo/asssocio questo controller o i suoi metodi
	// a uno o più Url, le richieste relative a questi Url
	//verranno indirizzate a questo controller e i suoi metodi
	
	
	///INTRO Json Array ["Corso Aava", "Corso Database"]
	//@RequestMapping(path = "/elenco-corsi", method = RequestMethod.GET)
	//@GetMapping("/elenco-corsi") // è la stessa cosa!
	@GetMapping(path = "/elenco-corsi", produces = MediaType.APPLICATION_JSON_VALUE)
	//@GetMapping(path = "/elenco-corsi", produces = "application/json") sono ==
	public ArrayList<String> getCorsi()
	{
		ArrayList<String> corsi = new ArrayList<String>();
		corsi.add("Corso Java");
		corsi.add("Corso Database");		
		
		return corsi;
		
	}
	
	//Json Object
	//@GetMapping("/studente")
	@GetMapping(path =  "/studente", produces = MediaType.APPLICATION_JSON_VALUE)
	public Studente getUnoStudente() {
		Studente studente = new Studente("Flavio","Rossi");
		return studente;		
	}
	
	@GetMapping("/studenti")
	public ArrayList<Studente> getTuttiStudenti() {
		
		//Rifattorizzare o rifattorizzazione
		//riscrivere in maniera più ordinata o riscrivere proprio il codeice sbagliato
		
		ArrayList<String> corsi = new ArrayList<String>();
		corsi.add("Corso Java");
		corsi.add("Corso Database");	
		
		ArrayList<Studente> tutti = new ArrayList<Studente>();
//		tutti.add(new Studente("Flavio","Rossi"));
//		tutti.add(new Studente("Mario","Verdi"));
		
		Studente uno = new Studente("Flavio","Rossi");		
		uno.setCorsi(corsi);
		
		Studente due = new Studente("Mario","Verdi");		
//		ArrayList<String> corsi2 = new ArrayList<String>();
//		corsi2.add("Corso Java");
//		corsi2.add("Corso Javascript");	
		//due.setCorsi(corsi2);	
		
		//List<String> foo = Arrays.asList("Corso Java","Corso Javascript");
		due.setCorsi(new ArrayList<String>( Arrays.asList("Corso Java","Corso Javascript") ));
		
		tutti.add(uno);
		tutti.add(due);
		
		return tutti;		
	}
	
	/**
	 * {id}: segnaposto che viene convertito da String a Tipo indicato nelle parentesi ()
	 * in questo caso un intero che indica lo studente che sto cercando
	 * 
	 * Variabile di percorso
	 * @PathVariable prende il valore scritto nella stringa url 
	 * e lo mette nella variabile int indicata nelle ("nomeVariabile")
	 * 
	 * 
	 * path: /api/base/studente/1
	 * @return
	 */
	@GetMapping("/studente/{id}")
	public Studente getStudenteById(@PathVariable("id") int id) //by == per id
	{
		//int risultato = Integer.parseInt("1");
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		studenti.add(new Studente(1, "Mario", "Rossi"));
		studenti.add(new Studente(2, "Paolo", "Verdi"));
		
		Studente studenteTrovato = new Studente();
		
		try {
			
			for (Studente studente : studenti) {
				if(studente.getId() == id)
				{
					//Status 200
					studenteTrovato =  studente;
					return studenteTrovato;
				}
			}
			
		} catch (Exception e) { //viene sollevata un'eccezione
			//status 500 internal server error
			//studenteTrovato = new Studente(); 
			System.out.println("Errore");
		}			
		
		//status 404 non trovato
		return studenteTrovato;	
	}
	
	
	/**
	 * QueryString:
	 * 	url che contine un elenco di parametri dopo il ?
	 * path: /api/base/studente-param?id=1
	 * @param id
	 * @return
	 */
	@GetMapping("/studente-param")
	public Studente getUnoStudenteByIdParameter(@RequestParam("id") int id)
	{
		//int risultato = Integer.parseInt("1");
		ArrayList<Studente> studenti = new ArrayList<Studente>();
		studenti.add(new Studente(1, "Mario", "Rossi"));
		studenti.add(new Studente(2, "Paolo", "Verdi"));
		
		Studente studenteTrovato = new Studente();
		
		try {
			
			for (Studente studente : studenti) {
				if(studente.getId() == id)
				{
					//Status 200
					studenteTrovato =  studente;
					return studenteTrovato;
				}
			}
			
		} catch (Exception e) { //viene sollevata un'eccezione
			//status 500 internal server error
			//studenteTrovato = new Studente(); 
			System.out.println("Errore");
		}			
		
		//status 404 non trovato
		return studenteTrovato;		
	}
	
	
	
	
	
	
	//INTRO BASE ================================================================================================
	/**
	 * Deprecato: perché i RestFul controllers dovrebbero restituire un json
	 * 
	 * getBase è solo il nome del metodo, potete chiamarlo come preferite, <br>
	 * ma serebbe meglio dargli un nome sensato <br>
	 * 
	 * mappatura: "/api/base/string" + GET
	 * cioè la somma della mappatura in testa al controller
	 * più la mappatura del metodo <br>
	 * 
	 * method = RequestMethod.GET risponde alle request di tipo GET <br>
	 * GET: recupera/prendi/cerca/ottieni (come getter di java) ti restituisce un dato
	 * @return String
	 */
	//@RequestMapping(path = "/string")
	@RequestMapping(path = "/string", method = RequestMethod.GET) //la stessa cosa
	public String getBase() {
		//va qui
		return "base";		
	}
	
	/**
	 * Deprecato: non è il modo migliore, ma è possibile...
	 * 
	 * mappatura/percorso: /api/base/html + GET
	 * 
	 * @return string html
	 */
	@RequestMapping(path = "/html", method =  RequestMethod.GET)
	public String getHtmlBrutto()
	{
		return "<html> <head></head> <body> <h1>html brutto</h1> </body> </html>";
	}
	
	
	
	/**
	 * mappatura: "/api/base/string" + POST
	 * POST: aggiungi un dato, ma può anche restituire un dato
	 * @return
	 */
	@RequestMapping(path = "/string",  method = RequestMethod.POST)
	public String getBase2() {
		//va qui
		return "base2";
		
	}
	

	
}
