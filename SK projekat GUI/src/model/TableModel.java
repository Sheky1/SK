package model;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	public TableModel() {
        super(new String[]{"Br","Ime", "Prezime", "Broj indeksa", "Smer"}, 0);
    }
}
