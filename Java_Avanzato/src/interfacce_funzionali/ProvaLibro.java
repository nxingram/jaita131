package interfacce_funzionali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProvaLibro {

	public static void main(String[] args) {
		
		ArrayList<Libro> libri = new ArrayList<Libro>();
		libri.add(new Libro("Il signore degli anelli", "Tolkien", 1225, 20.25));
		libri.add(new Libro("Dieci piccoli indiani", "Agatha Christie", 208, 10.20));
		libri.add(new Libro("Harry Potter e la Pietra Filosofale", "J. K. Rowling", 1402, 8.50));
		libri.add(new Libro("Lo Hobbit", "Tolkien", 20545, 33.25));
		
		//originale
		StampaLibri(libri);		
		
		//1) ordinati per titolo con Comparable
		Collections.sort(libri);
		StampaLibri(libri);	
		
		//2) ordinati per pagine con Comparator
		Collections.sort(libri, new LibroComparatorPagine());
		StampaLibri(libri);	
		
		//3)ordinati per prezzo decrescente con Classe anonima /*LibroComparatorPrezzo */ 
		Collections.sort(libri, new Comparator<Libro>() {
			
			@Override
			public int compare(Libro l1, Libro l2) {
				// TODO Auto-generated method stub
				return (int) (l2.getPrezzo() - l1.getPrezzo());
			}
			
		});
		StampaLibri(libri);	
		
		
		//Lambda Functions
		//https://github.com/nxingram/java-base/tree/main/interfacce-funzionali/src
		//https://github.com/maboglia/CorsoJava/blob/master/appunti/018_interfacce_funzionali.md

		//4) ordinata per numero pagine decrescente, non creo nemmeno la classe anonima, uso solo il metodo overridato
//		Collections.sort(libri, (l1, l2) -> l2.getPagine() - l1.getPagine());
		Collections.sort(libri, (l1, l2) -> l1.getPagine() - l2.getPagine());
		StampaLibri(libri);	
		
		// int compare(Libro l1, Libro l2)
		Comparator<Libro> comparatore =  (l1, l2) -> l1.getPagine() - l2.getPagine();
		Collections.sort(libri, comparatore);
		
		//5)tipo Consumer: accetta argomento di tipo T e non restituisce nulla		
		libri.forEach(libro -> System.out.println(libro));
		System.out.println("------------------------");
		
		//6) tipo Predicate + Comparator + Consumer
		libri
			.stream() //crea un flusso sul quale posso concatenare altre lambda functions
			.filter(libro -> libro.getPrezzo() < 20) //predicato: (filtra) Accetta un argomento di tipo T e restituisce un valore booleano.
			.sorted( (l1, l2) -> l1.getPagine() - l2.getPagine() ) //ordina per pagine asc
			.forEach(l -> System.out.println(l));
		System.out.println("------------------------");
		
		//7) Streams
		//https://gist.github.com/nxingram/05f7d43d253095b61fcc4f8af15353e5
		
		//consumer
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept("ciao");
		System.out.println("------------------------");
		
		//predicate
		Predicate<Integer> predicate = i -> i < 20;
		System.out.println(predicate.equals(33));
		System.out.println("------------------------");
		
		//function
		Function<String, Integer> funzione = s -> s.length();
		System.out.println(funzione.apply("mario"));
		System.out.println("------------------------");
		
		//supplier
		Supplier<String> supplier = () -> "Ciao!";
		System.out.println(supplier.get());
		System.out.println("------------------------");
		
		//predicate filter
		IntStream
			.range(1, 91)
			.filter(n -> n%3 == 0)
			.forEach(n -> System.out.println(n));
		System.out.println("------------------------");
		
		//somma
		int somma = IntStream
		.range(1, 91)
		.filter(n -> n%3 == 0)
		.sum();
		System.out.println(somma);
		
		
		//stream con Method Reference (System.out::println)
		Stream.of(3,5,6,8,11).filter(n -> n%2==0).forEach(System.out::println);
		System.out.println("------------------------");
		
		//collect
		//vuole un Collector
		String[] nomi = {"romolo", "remo", "giovanni", "francesca"};
		List<String> listaNomiCorti = Arrays.stream(nomi)
											.filter(n -> n.length()<6)
											.sorted()
											//.collect(Collectors.toList()); //java 8-15
											.toList(); //da java 16
		
		listaNomiCorti.forEach(System.out::println);
		System.out.println("------------------------");
		
		//summary statistics
		//elenco statistiche sugli elementi dello stream
		System.out.println(   IntStream.of(34,27,89,66,10,1,59).summaryStatistics()   );
		System.out.println("------------------------");
		
		
		//MAP
		//una function che accetta un libro e restituisce una stringa
		List<String> listaAutori = libri.stream()
										.map(libro -> libro.getAutore())
										.distinct() //elimina i doppioni
										.sorted()
										.toList();
		
		listaAutori.forEach(System.out::println);
		System.out.println("------------------------");
		
		//.map(libro -> new AutoreDto(libro.getAutore()))
		
		MiaFunction<String, String> reverseString = s -> new StringBuilder(s).reverse().toString(); 
		System.out.println("Inverso di \"HELLO\": " + reverseString.apply("HELLO"));
		
		
		
	}

	private static void StampaLibri(ArrayList<Libro> libri) {
		for (Libro libro : libri) {
			System.out.println(libro);
		}
		System.out.println("---------------------------------");
		
	}

}
