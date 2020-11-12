package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.Coche;

public class Controlador {
	
	final static List<Coche> lista = new ArrayList<Coche>();
	File fch = new File("archivo.txt");
	
	public static void addElement(Coche c, int pos) {
		
		
		lista.add(pos, c);
		
		
	}
	
	public static List<Coche> getElements (){
		
		
		
		return lista;
		
	}
}
