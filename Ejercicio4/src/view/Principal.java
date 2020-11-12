package view;

import java.util.ArrayList;
import java.util.List;
import controller.Controlador;

import model.Coche;

public class Principal {
	final static List<Coche> lista = new ArrayList<Coche>();
	public static void main(String[] args) {
		
		Coche c = new Coche("Citroen", "C4", 120, false);
		int pos=1;
		
		
		Controlador.addElement(c,pos);
		
		Controlador.getElements();
		
	}
	
}
