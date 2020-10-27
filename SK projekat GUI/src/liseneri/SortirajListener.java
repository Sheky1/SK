package liseneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.GlavniProzor;
import specifikacija.Entitet;

public class SortirajListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<Entitet> lista = new ArrayList<Entitet>();
		
		Object[] options = {"Po ID-ju", "Po nazivu", "Odustani"};
		int n = JOptionPane.showOptionDialog(
			GlavniProzor.getProzor(),
			"Kako zelite da sortirate podatke?",
			"Odabir nacina sortiranja",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[2]
		);
		
		if(n == JOptionPane.YES_OPTION) {
			GlavniProzor.getProzor().getSkladiste().sortiraj(true, lista);
		}
		else {
			GlavniProzor.getProzor().getSkladiste().sortiraj(false, lista);
		}
		
	}

}
