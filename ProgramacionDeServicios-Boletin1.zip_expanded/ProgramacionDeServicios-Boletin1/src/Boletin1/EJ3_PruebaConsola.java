package Boletin1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import validaciones.ValidaLibrary;

public class EJ3_PruebaConsola {

	public static void main(String[] args) throws IOException {
		String sRuta = ValidaLibrary.leer("Introduzca ruta: ");
		File fch = new File(sRuta);
		Path pth = Paths.get(sRuta);
		
		if(fch.isDirectory()) {
			String[] lista = fch.list();
		for(int i =0;i<fch.list().length;i++) {
			
			System.out.println(lista[i]);
			
		}
		
			
		}
		
		else if(fch.isFile()) {
			List<String> texto = Files.readAllLines(pth);
			
			for(String cadena : texto) {
				System.out.println(cadena);
			}
		}
		
		else {
			
			System.err.println("Error");
		}
		
		
	}

}
