package specifikacija;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;

public abstract class Specifikacija {

	private String filename;
	private ArrayList<Entitet> podaci;
	
	public Specifikacija() {		
	}

	public abstract void napraviBazu(String putanja);
	public abstract void pretrazi();
	public abstract void promeni(int id);
	public abstract void upisi(List<Entitet> entiteti);
	public abstract void ucitaj(List<Entitet> entiteti);
	
	public void napraviBazu() {
		String putanja = "";
		
		JFileChooser fc = new JFileChooser();
		
		setFilename(putanja);
		napraviBazu(putanja);
	}
	public void otvoriBazu(String putanja) {
		
		JFileChooser fc = new JFileChooser();

		setFilename(putanja);
	}

	public void dodaj(String naziv, String textArea) {
		Map<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(naziv, polja);
		podaci.add(noviEntitet);
		upisi(podaci);
	}
	public void dodaj(String idString, String naziv, String textArea) { 
		int id = Integer.parseInt(idString);
		Map<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(id, naziv, polja);
		podaci.add(noviEntitet);
		upisi(podaci);
	}

	public void obrisi(String idString) {
		int id = Integer.parseInt(idString);
		for (Entitet entitet : podaci) {
			if(id == entitet.getId()) {
				podaci.remove(entitet);
			}
		}
		upisi(podaci);
	}
	public void obrisi(String naziv, String textArea) { 
		Map<String, String> polja = parsirajTextarea(textArea);
		List<Entitet> zaBrisanje = new ArrayList<Entitet>();
		for (Entitet entitet : podaci) {
			int brojPoklopljenih = 0;
			if((entitet.getNaziv()).equals(naziv)) {
				for(Map.Entry<String, String> par: polja.entrySet()) {
					
				}
			}
		}
		upisi(podaci);
	}
	
	public HashMap<String, String> parsirajTextarea(String tekst) {
		HashMap<String, String> polja = new HashMap<String, String>();
		String[] redovi = tekst.split("\n");
		for(int i = 0; i < redovi.length; i++) {
			String[] red = redovi[i].split(":");
			String kljuc = red[0];
			String vrednost = red[1];
			polja.put(kljuc, vrednost);
		}
		
		return polja;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public ArrayList<Entitet> getPodaci() {
		return podaci;
	}

	public void setPodaci(ArrayList<Entitet> podaci) {
		this.podaci = podaci;
	}
	
}
