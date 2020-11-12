import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FichBinario {
	

	public static void main(String[] args) {
		File File_Name_Source = new File("fotos/Sevilla.jpg");
		File File_Name_Target = new File("fotos/ciudad.jpg");
		
		CopyFileBinary(File_Name_Source, File_Name_Target);

	}

	private static void CopyFileBinary(File file_Name_Source, File file_Name_Target) {
		try {
			
			FileInputStream fchSource = new FileInputStream(file_Name_Source);
			DataInputStream dataSource = new DataInputStream(fchSource);
			
			FileOutputStream fchTarget = new FileOutputStream(file_Name_Target);
			DataOutputStream dataTarget = new DataOutputStream(fchTarget);
			
			int byteRead;
			byteRead = dataSource.read();
			while(byteRead != -1) {
				dataTarget.write(byteRead);
				byteRead = dataSource.read();
			}
			
			
			dataTarget.close();
			fchTarget.close();
			dataSource.close();
			fchSource.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("Error al leer el archivo");
		} catch (IOException e) {
			System.err.println("Error accediendo al archivo");
		}
		
	}

}
