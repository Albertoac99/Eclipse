import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {
		File fch = new File("ejemplos\\ciudades.txt");
		String fch0 = "ejemplos\\ciudades.txt";
		String fchcopia = "ejemplos\\copia.txt";
		boolean fchEsDirectorio = fch.isDirectory();
		boolean fchExiste = fch.exists();
		int total = countChar(fch0, 'a');
		
		if(fchExiste && !fchEsDirectorio) {
		//InfoFichero(fch, fchEsDirectorio);
		//readFileChar(fch0);
		//System.out.println(total);
		//System.out.println("El archivo tiene " +countLines(fch0)+ " lineas");
		//System.out.println("El archivo tiene " +countWords(fch0)+ " palabras");
		copyFileChar(fch0,fchcopia);
		}
		else {
			System.out.println("El archivo no existe");
		}
	}
	
	private static void writeFileChar(String fch0, char c) {
		try {
			FileWriter fch = new FileWriter(fch0);
			fch.write(c);
			fch.close();
		}catch (IOException e) {
			System.out.println("Error de acceso");
		}
	}

	private static void InfoFichero(File fch, boolean fchEsDirectorio) {
		
		long fchBytes = fch.length();
		boolean fchPermisoLectura = fch.canRead();
	    boolean fchPermisoEscritura = fch.canWrite();
		boolean fchPermisoEjecucion = fch.canExecute();
		long fchB = fch.getFreeSpace();
		long fchMB = fchB / (1024*1024);
		long fchGB = fchMB / 1024;
		
		String fchNombre = fch.getName();
		System.out.println("Nombre: " +fchNombre);
		System.out.println("Tamaño: " +fchBytes+ " bytes");
		System.out.println("Es Directorio: " +SiNo(fchEsDirectorio));
		System.out.println("Tiene permisos de lectura: " +SiNo(fchPermisoLectura));
		System.out.println("Tiene permisos de escritura: " +SiNo(fchPermisoEscritura));
		System.out.println("Tiene permisos de ejecución: "+SiNo(fchPermisoEjecucion));
		String fchParent = fch.getParent();
		System.out.println("La carpeta padre es: " +fchParent);
		String fchRutaAbsoluta = fch.getAbsolutePath();
		System.out.println("La ruta absoluta es: " +fchRutaAbsoluta);
		System.out.println("Mumero de Bytes: "+fchB);
		System.out.println("Número de MB: "+fchMB);
		System.out.println("Número de GB: "+fchGB);
	}

	private static String SiNo(boolean valorLogico) {
		return valorLogico ? "Sí" : "No";
	}
	
	private static void readFileChar(String fch0) {
		try {
			int caracter;
			FileReader fch1 = new FileReader(fch0);
			caracter = fch1.read();
			while(caracter != -1) {
				System.out.println((char)caracter + "\t" + caracter);
				caracter = fch1.read();
			}
			fch1.close();
		}catch(FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}catch (IOException e) {
			System.out.println("Error de acceso");
		}
	}
	
	private static int countChar(String fch0, char letra) {
		int caracter;
			int cont = 0;
			try {
			
			FileReader fch1 = new FileReader(fch0);
			caracter = fch1.read();
			while(caracter != -1) {
				if((char) caracter == letra) {
					cont ++;
				}
				caracter = fch1.read();
			}
			fch1.close();
		}catch(FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}catch (IOException e) {
			System.out.println("Error de acceso");
		}
		return cont;
	}

	private static int countLines(String fch0) {
		int caracter;
		int cont = 1;
		try {
		
		FileReader fch1 = new FileReader(fch0);
		caracter = fch1.read();
		while(caracter != -1) {
			
			if(caracter == 13) {
				cont ++;
			}
			caracter = fch1.read();
		}
		fch1.close();
	}catch(FileNotFoundException e) {
		System.out.println("Fichero no encontrado");
	}catch (IOException e) {
		System.out.println("Error de acceso");
	}
		
		
		return cont;
	}
	
	private static int countWords(String fch0) {
		int caracter;
		int cont = 1;
		try {
		
		FileReader fch1 = new FileReader(fch0);
		caracter = fch1.read();
		while(caracter != -1) {
			
			if(caracter == 32 || caracter == 13) {
				cont ++;
			}
			caracter = fch1.read();
		}
		fch1.close();
	}catch(FileNotFoundException e) {
		System.out.println("Fichero no encontrado");
	}catch (IOException e) {
		System.out.println("Error de acceso");
	}
		
		
		return cont;
	}
	
	private static void copyFileChar(String fch0, String fchcopia) {
		int caracter;
		int cont=0;
		try {
		
		FileReader fch1 = new FileReader(fch0);
		FileWriter fch2 = new FileWriter(fchcopia);
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
