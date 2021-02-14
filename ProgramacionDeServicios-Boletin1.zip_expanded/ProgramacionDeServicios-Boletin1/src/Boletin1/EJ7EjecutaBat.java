package Boletin1;

import java.io.IOException;

public class EJ7EjecutaBat {

	public static void main(String[] args) {
		Runtime EjBat = Runtime.getRuntime();
		
		try {
			EjBat.exec("cmd.exe /c > ping ejecutaBat\\archivo.bat >> ejecutaBat\\salidaBat.txt 2>> ejecutaBat\\errorBat.txt");
		} catch (IOException e) {

			System.err.println("Error");
			
		}

	}

}
