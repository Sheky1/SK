package main;

import javax.swing.JOptionPane;

import gui.GlavniProzor;

public class Main {

	public static void main(String[] args) {
		GlavniProzor.getProzor().setVisible(true);
		
		boolean novoSkladiste = true;
		
		Object[] options = {"Novo skladiste", "Postojece skladiste"};
		int n = JOptionPane.showOptionDialog(
			GlavniProzor.getProzor(),
			"Odakle zelite da povucete podatke?",
			"Skladiste",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[1]
		);
		if(n == JOptionPane.NO_OPTION) novoSkladiste = false;
		GlavniProzor.getProzor().postaviSkladiste(novoSkladiste);
		

	}

}
