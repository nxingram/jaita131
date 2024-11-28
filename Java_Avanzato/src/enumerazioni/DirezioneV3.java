package enumerazioni;

public enum DirezioneV3 {
	NORD(),
	SUD("S"),
	OVEST("O"),
	EST("E");
	
	private final String codice;
	
	private DirezioneV3() {
		this.codice = "N";
	}

	private DirezioneV3(String codice) {
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}
	
	


}
