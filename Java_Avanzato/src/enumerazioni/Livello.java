package enumerazioni;

public enum Livello {

	BASSO(1,3),
	MEDIO(4,6),
	ALTO(7,9);
	
	//final: costanti
	private final int min;
	private final int max;
	
	private Livello(int min, int max)
	{
		this.min = min;
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	
	
	
}
