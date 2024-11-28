package Model.Dto;

import enumerazioni.DirezioneV3;

public class Studente  extends Persona {

	private DirezioneV3 aula;
	
	public Studente(String nome, String cognome, int eta) {
		super(nome, cognome, eta);
		this.aula = DirezioneV3.OVEST;
	}
	
	public Studente(String nome, String cognome, int eta, DirezioneV3 aula) {
		super(nome, cognome, eta);
		this.aula = aula;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("nome:" + getNome());
		s.append(", cognome:" + getCognome());
		s.append(", eta:" + getEta());
		s.append(", aula:" + aula + "(" + aula.getCodice() + ")");		
		return s.toString();
	}
	
	

}
