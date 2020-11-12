import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileChar {

	public static void main(String[] args) {
		
		final String FILE_NAME_SOURCE = args[0];
		final String FILE_NAME_TARGET = args[1];

		copyFileChar(FILE_NAME_SOURCE,FILE_NAME_TARGET);
	}
	
	private static void copyFileChar(String FILE_NAME_SOURCE, String FILE_NAME_TARGET) {
		int caracter;
		int cont=0;
		try {
		
		FileReader fch1 = new FileReader(FILE_NAME_SOURCE);
		FileWriter fch2 = new FileWriter(FILE_NAME_TARGET);
		caracter = fch1.read();
		while(caracter != -1) {
			cont++;
			fch2.write(caracter);
			caracter = fch1.read();
		}
		System.out.println("El número de bytes copiados es: " +cont);
		fch1.close();
		fch2.close();
	}catch(FileNotFoundException e) {
		System.out.println("Fichero no encontrado");
	}catch (IOException e) {
		System.out.println("Error de acceso");
	}
	}

}
