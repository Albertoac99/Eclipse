package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class LogPrincipal {

	public static void writeDataObject(String FILE_NAME, List<Producto> listado) {
		try {
			
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			for(Producto c : listado) {
				fch.writeObject(c);
			}
			
			fch.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Producto> readDataObject(String FILE_NAME) {
		
		
		List<Producto> listado = new ArrayList<Producto>();
		
		try {
			
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			Object obj = fch.readObject();
			
			while(obj!=null) {
				if(obj instanceof Producto) {
					listado.add((Producto) obj);
				}
				obj = fch.readObject();
			}
			
			
			
			fch.close();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		
		return listado;
	}
}
