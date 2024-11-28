package by_value_by_reference;

import Model.Dto.Persona;

public class ProvaByValueByReference {

	public static void main(String[] args) {
		//riabili passate per valore e per riferimento
		
		int interoPrimitivo = 3;
		String frase = "Prova a cambiarmi";
		Persona persona = new Persona("Mirco", "Rossi", 34);
		
		//passaggio variabile per valore
		cambiaEStampaNumero(interoPrimitivo);
		//qui quanto vale?
		System.out.println(interoPrimitivo);
		
		//Oggetti si passano per riferimento (di memoria)
		//ma la Stringa è un pò speciale perchè è immutabile
		cambiaStringa(frase);
		System.out.println(frase);
		
		//Implicitamente il passaggio è per riferimento
		//se  fosse esplicito ci sarebbe scritto byReference
		System.out.println(persona); 
		modificaPersona(persona);
		System.out.println(persona.getNome() + " " + persona.getEta());
		
		StringBuilder stringaByreference = new StringBuilder();
		stringaByreference.append("inizio");
		stringaByreference.append(" e poi ");
		stringaByreference.append(" continua");


		System.out.println(stringaByreference.toString());
		modificaStringBuilder(stringaByreference);
		System.out.println(stringaByreference.toString());
		
		stringaByreference.append("<html>");
		stringaByreference.append("<body>");
		stringaByreference.append("<div>");
		stringaByreference.append(persona.getNome());		
		stringaByreference.append("</div>");
		stringaByreference.append("</body>");
		stringaByreference.append("</html>");
		
		System.out.println(stringaByreference.toString());
		String Html = "<html>........................ </html>";
		
	}
	
	
	private static void modificaStringBuilder(StringBuilder stringaByreference) {
		stringaByreference.append(" nel metodo");	
		System.out.println( stringaByreference.toString());
	}


	private static void modificaPersona(Persona persona) {
		//implicitamente chiama ToString() di Object
		System.out.println(persona); 
		System.out.println(persona.getNome() + " " + persona.getEta());
		persona.setNome("Pippo");
		persona.setEta(23);		
		System.out.println(persona.getNome() + " " + persona.getEta());
	}


	//Scope della variabile
	//numeroPrimitivo viene creato all'inizio del metodo e sparisce quando finisce il metodo
	private static void cambiaEStampaNumero(int numero)
	{//caricata in memoria
		numero += 10;
		System.out.println(numero);
	} //qui sparisce il parametro/variabile numero
	
	private static void cambiaStringa(String fraseMetodo)
	{
		//Stringa immutabile, 
		//qui crea una nuova stringa
		//per riferimento vecchio e punta la nuovo
		fraseMetodo += " nel metodo";
		System.out.println(fraseMetodo);
	}
	
}
