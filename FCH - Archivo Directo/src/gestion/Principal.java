package gestion;

import java.util.List;

import controller.GestFchAD;
import model.Persona;

public class Principal {

	public static void main(String[] args) {
		
		GestFchAD miFch = new GestFchAD("datos.db");
		
		miFch.writeReg(1, new Persona("Pepe", 45, 1.68));
		miFch.writeReg(2, new Persona("Ana", 27, 1.5));
		
		System.out.println(miFch.readReg(1));
		System.out.println(miFch.readReg(2));
		
		System.out.println("Total de registros = " + miFch.totReg());
		
		List<Persona> gente = miFch.getContent();
		
		for (Persona p : gente)
			System.out.println(p);
 		
		
		
		miFch.closeFch();

	}

}
