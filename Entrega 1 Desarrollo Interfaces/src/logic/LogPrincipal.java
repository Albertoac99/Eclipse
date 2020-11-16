package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import view.Principal;

public class LogPrincipal {

	public static List<String> leerFichero(String File_Name) {
		List<String> contenido = new ArrayList<String>();
		
		try {
			 
			FileReader fch = new FileReader(File_Name);
			BufferedReader lectura = new BufferedReader(fch);
			
			String lineaLeida;
			
			lineaLeida = lectura.readLine();
			while(lineaLeida != null){
				contenido.add(lineaLeida);
				lineaLeida = lectura.readLine();
			}
			
		
			lectura.close();
			fch.close();
			
			
			
		}catch(FileNotFoundException e) {
			System.out.println("Error al encontrar el archivo "+ File_Name);
		}catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		return contenido;
	}

	public static void escribirFichero(String File_Name, List<String> contenido) {
		try {
		FileWriter fch = new FileWriter(File_Name);
		BufferedWriter escritura = new BufferedWriter(fch);
		
		
		for(int i=0; i<contenido.size()-1; i++) {
			escritura.write(contenido.get(i));
			escritura.newLine();
		}
		escritura.write(contenido.get(contenido.size()-1));
		
		
		escritura.close();
		fch.close();
		}catch(IOException e) {
			System.out.println("Error accediendo al fichero");
		}
				
	}
	
	public static String caracteres() {
		
		String caracteres =""+ Principal.textArea.getText().toString().length();
		
		return caracteres;
	}

	
}
