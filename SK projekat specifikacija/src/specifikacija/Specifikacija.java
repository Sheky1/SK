package specifikacija;

import java.util.List;

public abstract class Specifikacija {

	private String filename;
	
	public Specifikacija() {		
	}

	public abstract void dodaj(Entitet e);
	public abstract void obrisi();
	public abstract void promeni();
	public abstract void pretrazi();
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
