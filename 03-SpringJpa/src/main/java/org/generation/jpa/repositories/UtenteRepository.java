package org.generation.jpa.repositories;

import org.generation.jpa.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	//JPQL: java persistance query language
	
	//aggiungo dei metodi
	Utente findByEmail(String email);
	
	//u è un alias della classe utente mappata sulla tabella utenti
	@Query("select u from Utente u where u.email = ?1")
	Utente trovaPerEmail(String emailAddress);
	
	//"as u" = è l'alias, "as" è opzionale
	@Query(nativeQuery = true, value = "select * from utenti as u where u.email = ?1")
	Utente trovaPerEmailNativo(String emailAddress);
	
}
