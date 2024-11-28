package input_output;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ProvaInputOutput {

	public static void main(String[] args) {
		
		String nome = "";
		//Scanner
		
		//Try with resource: prova ad eseguire con la risorsa
		//e alla fine chiudi in automatico
		try(Scanner sc = new Scanner( new BufferedReader( new FileReader("folder/Dati-in.txt"))))
		{
			while (sc.hasNext()) {
				nome = sc.nextLine();
				System.out.println(nome);				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File non trovato");
		}
		
		
		
	}
}
