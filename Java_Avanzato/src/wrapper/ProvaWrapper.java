package wrapper;

import java.util.ArrayList;

import Model.Dto.Persona;
import Model.Dto.Studente;

public class ProvaWrapper {

	public static void main(String[] args) {
		int valore = 5;
		
		Integer valore2 = 10;	
		//conversione automatica ad Integer ad int primitivo
		int valore3 = valore2;
		
		//conversione automatica da int ad Integer
		Integer valore4 = valore;
		
		
		//Interger == Classe wrapper
		//classe che avvolge il valore primitivo in un oggetto
		//la conversione è automatica
		
		System.out.println(valore);
		System.out.println(valore2);
		System.out.println(valore3);
		System.out.println(valore4);
		

		System.out.println(valore4 + 10);
		//valore. //primitivo non ha metodi
		//valore4. //Oggetto che ha metodi
		
		Character c =  'c';
		//Double
		//Long
		//etc.
		
		//valore2: parametro attuale o argomento
		provaByValue(valore2);
		System.out.println(valore2);//10
		
		String numeroS = "2";
		Integer numeroInt = Integer.parseInt(numeroS);
		numeroInt++;
		System.out.println(numeroInt.toString());
		
		double d = Double.parseDouble("1.5");
		
		
		String s = "ciao";
		String s2 = "ciao";
		String s3= new String("ciao");
		
		System.out.println(s == s2); //true x risparmiare spazio in memoria non la ricrea
		System.out.println(s == s3);//false nuova string
		System.out.println(s.equals(s3)); //true
		
		//A cosa servono i Wrappers? ai tipi generici
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int numeroDue = 2;
		lista.add(numeroDue);
		
		ArrayList lista2 = new ArrayList();
		ArrayList<Persona> lista3 = new ArrayList();

		ArrayList<Studente> lista4 = new ArrayList();
		//lista4.add(new Persona("nome", "cognome", 55));
		
	}

	//valore2: parametro formale o parametro e basta
	private static void provaByValue(Integer valore2) {
		valore2 ++;
		System.out.println(valore2);//11
		
	}
	
}
