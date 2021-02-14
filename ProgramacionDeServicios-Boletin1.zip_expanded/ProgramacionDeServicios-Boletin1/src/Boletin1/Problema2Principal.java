package Boletin1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import validaciones.ValidaLibrary;

public class Problema2Principal {

	public static void main(String[] args) {
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		byte bOpcion;
		
		bOpcion = (byte) ValidaLibrary.valida("Indique que desea:\n1- Comprobar Usuario\n2- Comparar Ficheros", 1, 2, 3);
		if(bOpcion==1) {
			String sNombre;
			sNombre = ValidaLibrary.leer("Introduzca el nombre de Usuario: ");
			argsM.add(sNombre);
			
			try {
				Process op1 = JavaProcess.exec(Problema2Utilidades.class, jvmArgs, argsM);
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		else {
			String sRuta1, sRuta2;
			sRuta1= ValidaLibrary.leer("Introduzca la ruta del primer archivo: ");
			sRuta2= ValidaLibrary.leer("Introduzca la ruta del segundo archivo: ");
			
			File ruta1 = new File(sRuta1);
			File ruta2 = new File(sRuta2);
			
			while(!ruta1.isFile() && !ruta2.isFile()) {
				
				sRuta1= ValidaLibrary.leer("Introduzca la ruta del primer archivo: ");
				sRuta2= ValidaLibrary.leer("Introduzca la ruta del segundo archivo: ");
				
				ruta1 = new File(sRuta1);
				ruta2 = new File(sRuta2);
				
			}
			
			argsM.add(sRuta1);
			argsM.add(sRuta2);
			System.out.println(argsM.get(0));
			try {
				Process op2 = JavaProcess.exec(Problema2Utilidades.class, jvmArgs, argsM);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
	}
}
