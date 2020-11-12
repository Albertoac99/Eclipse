import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Principal {

		
	public static void main(String[] args) {
		
		int clave = 3;
		
		encriptar("archivos\\libros.txt","archivos\\books.txt",clave);
		encriptar("archivos\\books.txt","archivos\\cuadernos.txt",clave);
		
	}
	
	public static void encriptar(String FILE_NAME_SOURCE, String FILE_NAME_TARGET, int clave) {
		
		try {

			int iCadena;
			String sResultado ="";
			
			
		
				FileReader fch1 = new FileReader("FILE_NAME_SOURCE");
				FileWriter fch = new FileWriter("FILE_NAME_TARGET");
				while((iCadena = fch1.read() + clave)!=(-1+clave)) {
					sResultado += (char)iCadena;
				}
				for(int i=0;i<sResultado.length();i++) {
					fch.write(sResultado.charAt(i));
				}
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
