package Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Modelo.Coche;

public class GestFchSer {

	public static void writeDataObject(String FILE_NAME, List<Coche> listado) {
		try {
			
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			for(Coche c : listado) {
				fch.writeObject(c);
			}
			
			fch.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static List<Coche> readDataObject(String FILE_NAME) {
		
		
		List<Coche> listado = new ArrayList<Coche>();
		
		try {
			
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			Object obj = fch.readObject();
			
			while(obj!=null) {
				if(obj instanceof Coche) {
					listado.add((Coche) obj);
				}
				obj = fch.readObject();
			}
			
			
			
			fch.close();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		
		return listado;
	}

	public static void writeDataList(String FILE_NAME, List<Coche> listado) {
		try {
			
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
				fch.writeObject(listado);
			
			
			fch.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static List<Coche> readDataList(String FILE_NAME) {
		
		
		List<Coche> listado = new ArrayList<Coche>();
		
		try {
			
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			listado = (ArrayList<Coche>) fch.readObject();
							
			
			
			fch.close();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		
		return listado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
