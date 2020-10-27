package model;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

	public TableModel() {
        super(new String[]{"ID","Ime", "Podaci"}, 0);
    }
}
