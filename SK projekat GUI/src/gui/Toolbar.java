package gui;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar{
	
	private JButton dodaj;
	private JButton obrisi;
	private JButton sacuvaj;
	private JButton ucitaj;
	
	protected Toolbar() {
		
		dodaj = new JButton("Dodaj studenta");
		obrisi = new JButton("Obrisi studenta");
		sacuvaj = new JButton("Sacuvaj studente");
		ucitaj = new JButton("Ucitaj studente");
		
		add(dodaj);
		add(obrisi);
		add(sacuvaj);
		add(ucitaj);
	}
	
	
}
