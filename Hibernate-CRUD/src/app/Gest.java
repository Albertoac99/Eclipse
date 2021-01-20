package app;


import java.util.List;

import model.Coche;

public class Gest {
	
	public static void testGest() {
		Coche c = Logic.getCoche(1);
		System.out.println(c);
	}

	public static void testSave() {
		Coche c = new Coche("HONDA", "CIVIC", 1900);
		System.out.println("GUARDANDO: " +c);
		boolean finishOK = Logic.saveCoche(c);
		if(finishOK) {
			System.out.println("Proceso correcto");
		}
		else {
			System.out.println("Se ha producido un error");
		}
	}

	public static void testUpdate() {
		Coche c = Logic.getCoche(1);
		System.out.println("ANTES: " +c);
		c.setMarca("Audi");
		System.out.println("DESPUES: " +c);
		boolean finishOK = Logic.saveOrUpdate(c);
		if(finishOK) {
			System.out.println("Proceso correcto");
		}
		else {
			System.out.println("Se ha producido un error");
		}
		
	}

	public static void testDelete() {
		Coche c = Logic.getCoche(1);
		System.out.println("BORRANDO: " +c);
		boolean finishOK = Logic.delete(c);
		if(finishOK) {
			System.out.println("Proceso correcto");
		}
		else {
			System.out.println("Se ha producido un error");
		}
		
	}

	public static void testListAll() {
		List<Coche> lstCoches = Logic.getAllCoches();
		System.out.println("Listado de coches:");
		
		/*for(Coche c : lstCoches) {
			System.out.println(c);
		}
		*/
		
		lstCoches.forEach(c -> System.out.println(c));
		
	}

	
	
	
}
