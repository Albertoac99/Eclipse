package controller;

import java.awt.Color;

import view.Colores;
import view.Principal;

public class ContColores {

	public static void cambiarColorFondo(Color color) {
		
		Colores.lblEjemplo.setBackground(color);
		Colores.lblEjemplo.setOpaque(true);
	}
	
	public static void cambiarColorFuente(Color color) {
		
		Colores.lblEjemplo.setForeground(color);
	}
	
	public static void CambiarColor() {
		
		if(Colores.lblEjemplo.getBackground()!=Colores.lblEjemplo.getForeground()) {
			Principal.textArea.setBackground(Colores.lblEjemplo.getBackground());
			Principal.textArea.setForeground(Colores.lblEjemplo.getForeground());
		}
		
		
	}

}
