package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GlavniProzor extends JFrame{
	
	private static GlavniProzor prozor;
	private Toolbar toolbar;
	private Inputs inputs;
	private JTable tabela;
	private JScrollPane skrol;
	private String testString;
	
	private GlavniProzor() {
		postavi();
	}

	public static GlavniProzor getProzor() {
		if (prozor == null) {
			prozor = new GlavniProzor();
		}
		return prozor;
	}

	private void postavi() {
		
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		Dimension dimenzija = toolkit.getScreenSize();
//		int visina = dimenzija.height;
//		int sirina = dimenzija.width;
		setSize(new Dimension(540, 550));
		
		setTitle("Softverske komponente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		testString = new String("caaocao");
		
		toolbar = new Toolbar();
		
		inputs = new Inputs();
		
		JPanel gornji = new JPanel();
		gornji.setLayout(new BorderLayout());
		gornji.add(toolbar, BorderLayout.NORTH);
		gornji.add(inputs, BorderLayout.SOUTH );
		
		tabela = new Tabela();
		skrol = new JScrollPane(tabela);
		skrol.setPreferredSize(new Dimension(1000,300));
		
		add(gornji, BorderLayout.NORTH);
		add(skrol, BorderLayout.SOUTH);
	}
}
