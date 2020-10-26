package liseneri;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.GlavniProzor;

public class DodajActionLisener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		Object[] options = {"Dodaj", "Odustani"};
//		int n = JOptionPane.showOptionDialog(
//			GlavniProzor.getProzor(),
//			"Would you like some green eggs to go "
//			+ "with that ham?",
//			"A Silly Question",
//			JOptionPane.YES_NO_OPTION,
//			JOptionPane.INFORMATION_MESSAGE,
//			null,
//			options,
//			options[1]
//		);
		
		JTextArea textArea = new JTextArea();
		
		String naziv = JOptionPane.showInputDialog("Naziv entiteta");
		if(!(naziv.equals(""))) {
			int data = JOptionPane.showConfirmDialog(GlavniProzor.getProzor(), new JScrollPane(textArea), "Podaci entiteta", JOptionPane.YES_NO_OPTION);
			if(data == JOptionPane.YES_OPTION) {
				System.out.println(textArea.getText());
				GlavniProzor.getProzor().getSkladiste().dodaj(naziv, textArea.getText());
			}
		}
		
		
	}

}
