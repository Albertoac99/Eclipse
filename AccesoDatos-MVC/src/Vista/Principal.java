package Vista;

import java.util.ArrayList;
import java.util.List;

import Controlador.GestFchSer;
import Modelo.Coche;

public class Principal {

	final static String FILE_NAME = "archivos\\datos.dat";
	
	public static void main(String[] args) {
		
		//escritura();
		lectura();
		

	}

	private static void escritura() {
		List<Coche> listado = new ArrayList<Coche>();
		listado.add(new Coche("Citroen", "C4", 1500));
		listado.add(new Coche("Audi", "A4", 1800));
		listado.add(new Coche("Citroen", "C3", 1100));
		
		//GestFchSer.writeDataObject(FILE_NAME, listado);
		GestFchSer.writeDataList(FILE_NAME, listado);
	}

	private static void lectura() {
		//List<Coche> listado = GestFchSer.readDataObject(FILE_NAME);
		List<Coche> lista = GestFchSer.readDataList(FILE_NAME);
		for(Coche c: lista) {
			System.out.println(c);
		}
		
		
	}   
}       





