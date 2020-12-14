package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class LogPrincipal {

	public static String establecerConexion(ConexionDB conexion) {
		
		if(conexion.checkConnectionDatabase()) {
			
			
			return "VÁLIDO";
			
		}
		else {
			
			return "ERROR";
		}
		
	}
	public static String establecerConexionMySQL(ConexionMySQL conexion) {
		
		if(conexion.checkConnectionDatabase()) {
			
			
			return "VÁLIDO";
			
		}
		else {
			
			return "ERROR";
		}
		
	}
	public static String leerFichero(String File_Name) {
		String contenido="";
		
		try {
			 
			FileReader fch = new FileReader(File_Name);
			BufferedReader lectura = new BufferedReader(fch);
			
			String lineaLeida;
			
			lineaLeida = lectura.readLine();
			while(lineaLeida != null){
				contenido+=(lineaLeida)+="\n";
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

	public static boolean salir() {
		if (JOptionPane.showConfirmDialog(null, "¿Desea salir de Consultas SQL?", "Confirmar Salir", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		}
		else {
		return false;
		}
	}

}
