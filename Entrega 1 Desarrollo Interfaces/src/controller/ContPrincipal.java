package controller;

import java.awt.FileDialog;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import logic.LogPrincipal;
import view.Principal;

public class ContPrincipal {
	
	public static String FinalDirectorioAbrir;
	public static String FinalDirectorioGuardarComo;
	public static int control=0;
	

	public static void abrir(JLabel lblXxx) {
		FileDialog FchAbrir = new FileDialog(Principal.frame, "Abrir documento...", FileDialog.LOAD);
		FchAbrir.setVisible(true);
		String directorio = FchAbrir.getDirectory();
		String fichero = FchAbrir.getFile();
		FinalDirectorioAbrir = directorio += fichero;
		Principal.textArea.setText(LogPrincipal.leerFichero(FinalDirectorioAbrir).get(0));
		numCaracteres(lblXxx);
		control = 1;
	}

	public static void guardar() {
		List<String> contenido = new ArrayList<String>();
		
		contenido.add(Principal.textArea.getText());
		
		if(control==1) {
			LogPrincipal.escribirFichero(FinalDirectorioAbrir, contenido);
		}
		else if(control==2) {
			LogPrincipal.escribirFichero(FinalDirectorioGuardarComo, contenido);
		}
		else {
			guardarComo(Principal.textArea);
		}
		
		
	}

	public static void numCaracteres(JLabel lblXxx) {
		lblXxx.setText(LogPrincipal.caracteres());
		
	}

	public static void guardarComo(JTextArea textArea) {
		
		List<String> contenido = new ArrayList<String>();
		
		contenido.add(textArea.getText());
		FileDialog FchGuardar = new FileDialog(Principal.frame, "Abrir documento...", FileDialog.SAVE);
		FchGuardar.setVisible(true);
		String directorio = FchGuardar.getDirectory();
		String fichero = FchGuardar.getFile();
		FinalDirectorioGuardarComo = directorio += fichero;
		LogPrincipal.escribirFichero(FinalDirectorioGuardarComo, contenido);
		control = 2;
	}

	public static void salir() {
		
		if (JOptionPane.showConfirmDialog(null, "¿Desea salir del editor de texto?", "Confirmar Salir", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}

}
