package specifikacija;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.plaf.FileChooserUI;

public abstract class Specifikacija {

	private String filename;
	private ArrayList<Entitet> podaci;
	
	public Specifikacija() {		
	}

	public abstract void napraviBazu(String putanja);
	public abstract void dodaj(Entitet noviEntitet);
	public abstract void pretrazi();
	public abstract void promeni(int id);
	public abstract void obrisi(List<Entitet> entiteti);
	
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
		HashMap<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(naziv, polja);
		dodaj(noviEntitet);
	}
	public void dodaj(String idString, String naziv, String textArea) { 
		int id = Integer.parseInt(idString);
		HashMap<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(id, naziv, polja);
		dodaj(noviEntitet);
	}

	public void obrisi(String idString) {
		int id = Integer.parseInt(idString);
		
	}
	public void obrisi(String idString, String naziv, String textArea) { 
		int id = Integer.parseInt(idString);
		HashMap<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(id, naziv, polja);
		dodaj(noviEntitet);
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
