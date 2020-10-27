package liseneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.omg.CORBA.TIMEOUT;

import gui.GlavniProzor;

public class DodajUgnjezdeniListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JTextArea textArea = new JTextArea();
		
		String naziv = JOptionPane.showInputDialog("Naziv entiteta");
		if(!(naziv.equals(""))) {
			int data = JOptionPane.showConfirmDialog(GlavniProzor.getProzor(), new JScrollPane(textArea), "Podaci entiteta", JOptionPane.YES_NO_OPTION);
			if(data == JOptionPane.YES_OPTION) {
				GlavniProzor.getProzor().getSkladiste().dodajUgnjezdeni(GlavniProzor.getProzor().getSelektovaniID(), naziv, textArea.getText());
				GlavniProzor.getProzor().getTableModel().update();
			}
		}
		
	}

}
