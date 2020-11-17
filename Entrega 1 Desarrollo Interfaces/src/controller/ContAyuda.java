package controller;

import logic.LogPrincipal;
import view.Ayuda;

public class ContAyuda {

	public static void abrir() {
		
		Ayuda.textArea.setText(LogPrincipal.leerFichero("archivos\\manual.txt"));
		
	}

}
