package org.generation.jpa.repositories;

import org.generation.jpa.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
/**
 * Repository Layer == DAL data access layer
 * 
 * JpaRepository è 1 delle svariate interfacce che posso estendere
 * 
 * T = Generico -> Utente (entità)
 * ID = Generico -> tipo della mia chiave primaria @Id - Long con la maiuscola xè i generici usano le classi wrapper
 * Repository che contiene le query mappate sull'entità utente
 */
//@Repository //opzionale
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	
	//aggiungo dei metodi
}
