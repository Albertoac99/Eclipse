package controller;

import javax.swing.JOptionPane;

import view.Principal;

public class ContPrincipal {
	
	public static void borrar() {
		
		if (JOptionPane.showConfirmDialog(null, "Confirmar el borrado del producto" +Principal.textField.getText(), "Confirmar Borrado", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
