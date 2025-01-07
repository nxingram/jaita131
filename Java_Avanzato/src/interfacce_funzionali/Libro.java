package interfacce_funzionali;

public class Libro  implements Comparable<Libro>{

	private String titolo;
	private String autore;
	private int pagine;
	private double prezzo;
	
	
	
	@Override
	public int compareTo(Libro o) {		
		return this.titolo.compareTo(o.titolo);
	}
	
	
	
	public Libro() {
	}

	public Libro(String titolo, String autore, int pagine, double prezzo) {

		this.titolo = titolo;
		this.autore = autore;
		this.pagine = pagine;
		this.prezzo = prezzo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", pagine=" + pagine + ", prezzo=" + prezzo + "]";
	}


	
	
	
	
	
}
