package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static List<String> leerFichero(String File_Name) {
		List<String> contenido = new ArrayList<String>();
		
		try {
			 
			FileReader fch = new FileReader(File_Name);
			BufferedReader lectura = new BufferedReader(fch);
			
		//tratamiento del contenido del fichero
			String lineaLeida;
			
			lineaLeida = lectura.readLine();
			while(lineaLeida != null){
				contenido.add(lineaLeida);
				lineaLeida = lectura.readLine();
			}
			
			
			//Cierre del fichero y del canal de comunicaciones de lectura
			lectura.close();
			fch.close();
			
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Error al encontrar el archivo "+ File_Name);
		}catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		return contenido;
	}
	
	public static List<String> CopiarFichero(String File_Name, String File_Target) {
		List<String> contenido = new ArrayList<String>();
		
		try {
			 
			FileReader fch = new FileReader(File_Name);
			FileReader fch1 = new FileReader(File_Target);
			BufferedReader lectura = new BufferedReader(fch);
			BufferedReader lectura2 = new BufferedReader(fch1);
			
		//tratamiento del contenido del fichero
			String lineaLeida, lineaLeida2;
			
			lineaLeida2 = lectura2.readLine();
			lineaLeida = lectura.readLine();
			
			while(lineaLeida != null && lineaLeida2 != null){
				contenido.add(lineaLeida2);
				contenido.add(" ");
				contenido.add(lineaLeida);
				lineaLeida2 = lectura2.readLine();
				lineaLeida = lectura.readLine();
			}
			
			
			//Cierre del fichero y del canal de comunicaciones de lectura
			lectura.close();
			fch.close();
			lectura2.close();
			fch1.close();
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Error al encontrar el archivo "+ File_Name);
		}catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		return contenido;
	}
	
}
