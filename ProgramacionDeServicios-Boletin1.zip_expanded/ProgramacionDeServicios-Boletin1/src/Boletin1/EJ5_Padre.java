package Boletin1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import validaciones.ValidaLibrary;

public class EJ5_Padre {

	public static void main(String[] args) throws IOException, InterruptedException {
		byte bRepetir;
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		
		Process p = JavaProcess.exec(EJ5_Hijo.class, jvmArgs, argsM);
		System.out.println(p.exitValue());
		bRepetir = (byte) ValidaLibrary.valida("¿Desea volver a lanzar el proceso hijo?\n 1- Si\n 2- No", 1, 2, 3);
		
		while(bRepetir==1) {
			p = JavaProcess.exec(EJ5_Hijo.class, jvmArgs, argsM);
			System.out.println(p.exitValue());
			bRepetir = (byte) ValidaLibrary.valida("¿Desea volver a lanzar el proceso hijo?\n 1- Si\n 2- No", 1, 2, 3);
			
		}
	}
}
