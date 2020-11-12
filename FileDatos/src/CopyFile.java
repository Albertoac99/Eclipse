import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {

	public static void main(String[] args) {
		final String File_Name = "ejemplos//ciudades1.txt";
		final String File_Target = "ejemplos//copia.txt";

		List<String> contenido = CopiarFichero(File_Name, File_Target);
		System.out.println(contenido);
	}

	private static List<String> CopiarFichero(String File_Name, String File_Target) {
		List<String> contenido = new ArrayList<String>();
		
		try {
			 
			FileReader fch = new FileReader(File_Name);
			FileReader fch1 = new FileReader(File_Name);
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
