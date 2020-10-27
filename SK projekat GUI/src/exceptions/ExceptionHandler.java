package exceptions;

import javax.swing.JOptionPane;

public class ExceptionHandler {

	public static void handle(String text) {
		JOptionPane.showMessageDialog(null, getPoruka(text), "Greska", JOptionPane.ERROR_MESSAGE);
	}
	
	private static String getPoruka(String text) {
		if(text.equals("naziv")) return "Niste uneli naziv.";
		else if(text.equals("dodavanje")) return "Greska prilikom dodavanja";
		return null;
	}
}
