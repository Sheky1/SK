package gui;

import javax.swing.JButton;
import javax.swing.JToolBar;

import liseneri.DodajActionLisener;

public class Toolbar extends JToolBar{
	
	private JButton dodaj;
	private JButton dodajUgjezdeni;
	private JButton obrisi;
	private JButton pretrazi;
	private JButton soritrajId;
	private JButton soritrajNaziv;
	
	protected Toolbar() {
		
		dodaj = new JButton("Dodaj");
		dodajUgjezdeni = new JButton("Dodaj Ugnjezdeni");
		obrisi = new JButton("Obrisi");
		pretrazi = new JButton("Pretrazi");
		soritrajId = new JButton("SortID");
		soritrajNaziv = new JButton("SortNAZIV");
		
		dodaj.addActionListener(new DodajActionLisener());
		
		add(dodaj);
		add(dodajUgjezdeni);
		add(obrisi);
		add(pretrazi);
		add(soritrajId);
		add(soritrajNaziv);
	}
	
	
}
