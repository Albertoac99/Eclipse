import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Proceso_Escritura {

	public static void main(String[] args) {
		
		final String File_Name = "ejemplos//ciudades1.txt";
		
		List<String> ciudades = new ArrayList<String>();
		ciudades.add("Sevilla");
		ciudades.add("Huelva");
		ciudades.add("Jaen");
		ciudades.add("Malaga");
		ciudades.add("Cordoba");
		
		escribirFichero(File_Name, ciudades);
	
		
		
	}

	private static void escribirFichero(String File_Name, List<String> contenido) {
		try {
		// Apertura del fichero y del canal de comunicaciones tipo búfer
		FileWriter fch = new FileWriter(File_Name);
		BufferedWriter escritura = new BufferedWriter(fch);
		
		// Tratamiento de los datos (escritura del parámetro: contenido)
		
		/*for(String linea : contenido) {
			escritura.write(linea);
		}
		*/
		
		for(int i=0; i<contenido.size()-1; i++) {
			escritura.write(contenido.get(i));
			escritura.newLine();
		}
		escritura.write(contenido.get(contenido.size()-1));
		
		
		
		
		
		// Cierre del fichero y del canal de comunicaciones ripo búfer
		escritura.close();
		fch.close();
		}catch(IOException e) {
			System.out.println("Error accediendo al fichero");
		}
				
	}

}
