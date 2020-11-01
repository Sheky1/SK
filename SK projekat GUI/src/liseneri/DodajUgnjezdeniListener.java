package liseneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import exceptions.ExceptionHandler;
import gui.GlavniProzor;

public class DodajUgnjezdeniListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextArea textArea = new JTextArea();
		
		if(GlavniProzor.getProzor().getSkladiste().isAuto()) {
			String naziv = JOptionPane.showInputDialog("Naziv entiteta");
			if(!(naziv.equals(""))) {
				int data = JOptionPane.showConfirmDialog(GlavniProzor.getProzor(), new JScrollPane(textArea), "Podaci entiteta", JOptionPane.YES_NO_OPTION);
				if(data == JOptionPane.YES_OPTION) {
					GlavniProzor.getProzor().getSkladiste().dodajUgnjezdeni(GlavniProzor.getProzor().getSelektovaniID(), naziv, textArea.getText());
					GlavniProzor.getProzor().getTableModel().update();
				}
			}
		} else {
			String id = JOptionPane.showInputDialog("ID entiteta");
			String naziv = JOptionPane.showInputDialog("Naziv entiteta");
			if(!(naziv.equals(""))) {
				int data = JOptionPane.showConfirmDialog(GlavniProzor.getProzor(), new JScrollPane(textArea), "Podaci entiteta", JOptionPane.YES_NO_OPTION);
				if(data == JOptionPane.YES_OPTION) {
					boolean uspeo = GlavniProzor.getProzor().getSkladiste().dodajUgnjezdeni(GlavniProzor.getProzor().getSelektovaniID(), id, naziv, textArea.getText());
					if(uspeo) GlavniProzor.getProzor().getTableModel().update();
					else ExceptionHandler.handle("postojeciID");
				}
			}
		}
		
		
	}

}
