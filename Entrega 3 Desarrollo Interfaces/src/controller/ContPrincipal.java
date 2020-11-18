package controller;

import javax.swing.JOptionPane;

import logic.LogPrincipal;
import view.Principal;

public class ContPrincipal {
	
	public static void borrar() {
		
		if (JOptionPane.showConfirmDialog(null, "Confirmar el borrado del producto" +Principal.textField.getText(), "Confirmar Borrado", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void abrir() {
		
		Principal.productos = LogPrincipal.readDataObject(Principal.RUTA);
		
	}

	public static void guardar() {
		
		String codigo = Principal.textField.getText();
		String nombre = Principal.textField_1.getText();
		int stockActual;
		int stockMinimo;
		int stockMaximo;
		int opcion;
		String comentario;
		int proveedor;
		boolean fragil;
		boolean obsoleto;
		float pvp;
		
		
		Principal.productos.add(new Producto());
		
	}
	
	

}
