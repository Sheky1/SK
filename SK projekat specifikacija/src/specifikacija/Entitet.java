package specifikacija;

import java.util.HashMap;
import java.util.Map;

public class Entitet {

	private int id;
	private String naziv;
	private Map<String, String> prostiPodaci;
	private Map<Integer, Entitet> ugnjezdeni;
	private static int autoinkrement = 0;
	
	public Entitet(String naziv, Map<String, String> prostiPodaci) {
		this.id = autoinkrement;
		autoinkrement++;
		this.naziv = naziv;
		this.prostiPodaci = prostiPodaci;
	}
	
	public Entitet(int id, String naziv, Map<String, String> prostiPodaci) {
		this.id = id;
		this.naziv = naziv;
		this.prostiPodaci = prostiPodaci;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Map<String, String> getProstiPodaci() {
		return prostiPodaci;
	}

	public void setProstiPodaci(Map<String, String> prostiPodaci) {
		this.prostiPodaci = prostiPodaci;
	}

	public Map<Integer, Entitet> getUgnjezdeni() {
		return ugnjezdeni;
	}

	public void setUgnjezdeni(Map<Integer, Entitet> ugnjezdeni) {
		this.ugnjezdeni = ugnjezdeni;
	}
	
	
	
}
