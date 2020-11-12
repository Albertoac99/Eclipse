import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Proceso_Lectura {

	public static void main(String[] args) {
		final String File_Name = "ejemplos//ciudades1.txt";
		
		//Apertura del fichero y del canal de comunicaciones de lectura
		//mostrarContenidoFichero(File_Name);
		List<String> contenido = leerFichero(File_Name);
		
		for(String cadena : contenido) {
			System.out.println("--> " +cadena);
		}
	}

	private static List<String> leerFichero(String File_Name) {
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

	private static void mostrarContenidoFichero(String File_Name) {
		try {
		 
		FileReader fch = new FileReader(File_Name);
		BufferedReader lectura = new BufferedReader(fch);
		
	//tratamiento del contenido del fichero
		String lineaLeida;
		
		lineaLeida = lectura.readLine();
		while(lineaLeida != null){
			System.out.println(lineaLeida);
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
		
		
		
		
	}

}
