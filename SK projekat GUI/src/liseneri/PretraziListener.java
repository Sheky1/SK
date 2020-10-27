package liseneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.GlavniProzor;

public class PretraziListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextArea textArea = new JTextArea();

		Object[] options = {"Po ID-ju", "Po parametrima", "Odustani"};
		int n = JOptionPane.showOptionDialog(
			GlavniProzor.getProzor(),
			"Kako zelite da pretrazite podatke?",
			"Odabir nacina pretrage",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			options[2]
		);
		
		if(n == JOptionPane.YES_OPTION) {
			String id = JOptionPane.showInputDialog("ID entiteta");
			if(id != null) GlavniProzor.getProzor().getSkladiste().pretrazi(id);
		}
		else {
			String naziv = JOptionPane.showInputDialog("Naziv entiteta");
			int data = JOptionPane.showConfirmDialog(GlavniProzor.getProzor(), new JScrollPane(textArea), "Podaci entiteta", JOptionPane.YES_NO_OPTION);
			if(data == JOptionPane.YES_OPTION) {
				GlavniProzor.getProzor().getSkladiste().pretrazi(naziv, textArea.getText());
			}
		}
		
	}

}
