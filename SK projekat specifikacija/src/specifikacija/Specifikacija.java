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
//	public abstract void pretrazi();
//	public abstract void promeni(int id);
	public abstract void upisi();
	public abstract void ucitaj();
	
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
		upisi();
	}
	public void dodaj(String idString, String naziv, String textArea) { 
		int id = Integer.parseInt(idString);
		Map<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(id, naziv, polja);
		podaci.add(noviEntitet);
		upisi();
	}
	
	public void dodajUgnjezdeni(String spoljniId, String naziv, String textArea) {
		int id = Integer.parseInt(spoljniId);
		Entitet spoljni = null;
		for (Entitet entitet : podaci) {
			if(id == entitet.getId()) {
				spoljni = entitet;
				break;
			}
		}
		Map<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(naziv, polja);
		spoljni.getUgnjezdeni().put(noviEntitet.getId(), noviEntitet);
		upisi();
	}
	public void dodajUgnjezdeni(String spoljniId, String idString, String naziv, String textArea) { 
		int id = Integer.parseInt(spoljniId);
		Entitet spoljni = null;
		for (Entitet entitet : podaci) {
			if(id == entitet.getId()) {
				spoljni = entitet;
				break;
			}
		}
		int idUgnj = Integer.parseInt(idString);
		Map<String, String> polja = parsirajTextarea(textArea);
		Entitet noviEntitet = new Entitet(idUgnj, naziv, polja);
		spoljni.getUgnjezdeni().put(noviEntitet.getId(), noviEntitet);
		upisi();
	}

	public void obrisi(String idString) {
		int id = Integer.parseInt(idString);
		int index = -1;
		for (Entitet entitet : podaci) {
			if(id == entitet.getId()) {
				index = podaci.indexOf(entitet);
				break;
			}
		}
		podaci.remove(index);
		upisi();
	}
	public void obrisi(String naziv, String textArea) { 
		Map<String, String> polja = parsirajTextarea(textArea);
		List<Integer> zaBrisanje = new ArrayList<Integer>();
		for (Entitet entitet : podaci) {
			int neBrisi = 0;
			if((entitet.getNaziv()).equals(naziv)) {
				for(Map.Entry<String, String> par: polja.entrySet()) {
					if(entitet.getProstiPodaci().containsKey(par.getKey())) {
						if(!(entitet.getProstiPodaci().get(par.getKey()).equals(par.getValue()))) {
							neBrisi = 1;
						}
					}
					else {
						neBrisi = 1;
					}
				}
				if(neBrisi == 0) {
					zaBrisanje.add(entitet.getId());
				}
			}
		}
		for(int i = zaBrisanje.size() - 1; i >= 0; i--) {
			podaci.remove(i);
		}
		upisi();
	}
	
	public List<Entitet> pretrazi(String naziv, String textArea) {
		Map<String, String> polja = parsirajTextarea(textArea);
		List<Entitet> zaPretragu = new ArrayList<Entitet>();
		for(Entitet entitet: podaci) {
			int nePretrazuj = 0;
			if((entitet.getNaziv()).equals(naziv)) {
				for(Map.Entry<String, String> par: polja.entrySet()) {
					if(entitet.getProstiPodaci().containsKey(par.getKey())) {
						if(!(entitet.getProstiPodaci().get(par.getKey()).equals(par.getValue()))) {
							nePretrazuj = 1;
						}
					}
					else {
						nePretrazuj = 1;
					}
				}
				if(nePretrazuj == 0) {
					zaPretragu.add(entitet);
				}
			}
		}
		return zaPretragu;
	}
	
	public List<Entitet> pretrazi(String idString) {
		int id = Integer.parseInt(idString);
		List<Entitet> zaPretragu = new ArrayList<Entitet>();
		for(Entitet entitet: podaci) {
			if(id == entitet.getId()) {
				zaPretragu.add(entitet);
				break;
			}
			
		}
		return zaPretragu;
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
