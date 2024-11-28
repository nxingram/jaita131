package enumerazioni;

import Model.Dto.Studente;

public class ProvaEnum {

	public static void main(String[] args) {
		//Static: devo istanziarlo con 1 costruttore? NO
		DirezioneV1 sud = DirezioneV1.SUD;
		System.out.println(sud);
		System.out.println(DirezioneV2.NORD);
		System.out.println(DirezioneV3.OVEST.getCodice());
		
		for (DirezioneV1 valore : DirezioneV1.values()) {
			System.out.println(valore);
		}
		
		for (DirezioneV3 valore : DirezioneV3.values()) {
			System.out.println(valore + " " + valore.getCodice() );
		}
		
		for (Livello valore : Livello.values()) {
			StringBuilder s = new StringBuilder();
			s.append(valore + ": ");
			s.append("min " + valore.getMin());
			s.append(", max " + valore.getMax());
			System.out.println(s.toString());
		}
		
		
		Studente sAula = new Studente("Mario", "Verdi", 13, DirezioneV3.SUD); 
		System.out.println(sAula);
		
	}
}
