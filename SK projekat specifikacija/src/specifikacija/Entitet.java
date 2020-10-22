package specifikacija;

import java.util.HashMap;
import java.util.Map;

public class Entitet {

	private int id;
	private String naziv;
	private Map<String, String> podaci;
	private static int autoinkrement = 0;
	
	public Entitet(String naziv, HashMap<String, String> podaci) {
		this.id = autoinkrement;
		autoinkrement++;
		this.naziv = naziv;
		this.podaci = podaci;
	}
	
}
