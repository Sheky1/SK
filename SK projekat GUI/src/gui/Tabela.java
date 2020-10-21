package gui;

import javax.swing.JTable;

import model.TableModel;

public class Tabela extends JTable{

	protected Tabela() {
		super(new TableModel());
		
	}
}
