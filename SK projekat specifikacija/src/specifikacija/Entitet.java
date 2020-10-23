package specifikacija;

import java.util.HashMap;
import java.util.Map;

public class Entitet {

	private int id;
	private String naziv;
	private Map<String, String> prostiPodaci;
	private Map<String, Entitet> ugnjezdeni;
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
	
}
