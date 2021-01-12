package app;

import java.util.List;

import model.Coche;

public class Gest {

	public static void insert() {
		Coche c = new Coche(1400, "Volkswagen", "Polo");
		Logic.insertCoche(c);
	}
	
	public static void get() {
		Coche c = Logic.getCoche(1);
		System.out.println(c);
	}

	public static void update() {
		Coche c = Logic.getCoche(1);
		c.setPotencia(900);
		Logic.update(c);
	}

	public static void delete() {
		Coche c = Logic.getCoche(1);
		Logic.deleteCoche(c);
		
	}

	public static void listAll() {
		List<Coche> lstCoches = Logic.getListAll();
		for(Coche c : lstCoches) {
			
			System.out.println(c);
		}
		
	}
	
	
}
