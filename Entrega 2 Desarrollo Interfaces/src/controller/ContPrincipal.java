package controller;

import java.awt.FileDialog;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import logic.LogPrincipal;
import view.Principal;


public class ContPrincipal {

	public static void limpiar(JTextArea area) {
		
		area.setText("");
		
	}

	public static void salir() {
		if(LogPrincipal.salir()) {
		System.exit(0);
		}
		
	}

	public static void guardar() {
		List<String> resultado = new ArrayList<String>();
		
		FileDialog FchAbrir = new FileDialog(Principal.frame, "Abrir documento...", FileDialog.LOAD);
		FchAbrir.setVisible(true);
		String directorio = FchAbrir.getDirectory();
		String fichero = FchAbrir.getFile();
		String FinalDirectorio = directorio += fichero;
		
		resultado.add(Principal.textArea.getText());
		resultado.add(Principal.textArea_1.getText());
		
		LogPrincipal.escribirFichero(FinalDirectorio, resultado);
		
	}

}
