import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class File_Serializacion {

	public static void main(String[] args) {
		//Creamos un objeto
		String FileName = "archivos\\datos.dat";
		Persona p = new Persona("Pepe", 37);
		//Escribimos el objeto
		try {
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FileName));
			
			fch.writeObject(p);
			fch.close();
			
			
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo");
		}
		//Leemos el objeto
		Persona nueva = new Persona(null, 0);
		try {
			ObjectInputStream lec = new ObjectInputStream(new FileInputStream(FileName));
		
			Object obj = lec.readObject();
			if(obj instanceof Persona) {
				nueva = (Persona) obj;
			}
			
			lec.close();
			
		} catch (IOException e) {
	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		
		//Mostrar el objeto
		System.out.println(nueva);

	}

}
