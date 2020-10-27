package model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import gui.GlavniProzor;
import specifikacija.Entitet;

public class TableModel extends DefaultTableModel {
	
	public TableModel() {
        super(new String[]{"ID","Ime", "Podaci"}, 0);
    }
    
    public void update() {
    	this.setRowCount(0);
        List<Entitet> podaci = GlavniProzor.getProzor().getSkladiste().getPodaci();
    	for (Entitet entitet : podaci) {
			int id = entitet.getId();
			String naziv = entitet.getNaziv();
			String info = entitet.getProstiPodaci().toString();
			
			Object[] data = {id, naziv, info};
			
			this.addRow(data);
		}
    }
}
