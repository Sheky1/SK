package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inputs extends JPanel{

	private JLabel ime;
	private JLabel prezime;
	private JLabel index;
	private JLabel smer;
	
	private JTextField imeTF;
	private JTextField prezimeTF;
	private JTextField indexTF;
	private JTextField smerTF;
	
	protected Inputs() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ime = new JLabel("Ime: ");
		prezime = new JLabel("Prezime: ");
		index = new JLabel("Broj indeksa: ");
		smer = new JLabel("Smer: ");
		
		imeTF = new JTextField();
		prezimeTF = new JTextField();
		indexTF = new JTextField();
		smerTF = new JTextField();
		
		imeTF.setPreferredSize(new Dimension(1000,25));
		prezimeTF.setPreferredSize(new Dimension(1000,25));
		indexTF.setPreferredSize(new Dimension(1000,25));
		smerTF.setPreferredSize(new Dimension(1000,25));
		
		imeTF.setMaximumSize(new Dimension(1000,25));
		prezimeTF.setMaximumSize(new Dimension(1000,25));
		indexTF.setMaximumSize(new Dimension(1000,25));
		smerTF.setMaximumSize(new Dimension(1000,25));
		
		add(ime);
		add(imeTF);
		add(prezime);
		add(prezimeTF);
		add(index);
		add(indexTF);
		add(smer);
		add(smerTF);
	}
}
