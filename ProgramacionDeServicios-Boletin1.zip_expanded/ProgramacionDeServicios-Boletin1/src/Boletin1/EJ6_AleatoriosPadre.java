package Boletin1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import validaciones.ValidaLibrary;

public class EJ6_AleatoriosPadre {

	public static void main(String[] args) throws IOException, InterruptedException {
		int max = 10, min = 0, iValor, iValorHijo, iRepetir; 
		Random r = new Random();
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		
		Process p = JavaProcess.exec(EJ6_AleatoriosHijo.class, jvmArgs, argsM);
		iValorHijo = p.exitValue();
		iValor = r.nextInt(max-min+1);
		System.out.println("Este es el valor del padre --> " +iValor);
		if(iValor == iValorHijo) {
			System.out.println("Los valores son iguales");
		}
		else {
			System.out.println("Los valores son distintos");
		}
		iRepetir = (int) ValidaLibrary.valida("¿Desea repetir el proceso?\n1- Si\n2- No", 1, 2, 1);
		while (iRepetir==1){
			p = JavaProcess.exec(EJ6_AleatoriosHijo.class, jvmArgs, argsM);
			iValorHijo = p.exitValue();
			iValor = r.nextInt(max-min+1);
			System.out.println("Este es el valor del padre --> " +iValor);
			if(iValor == iValorHijo) {
				System.out.println("Los valores son iguales");
			}
			else {
				System.out.println("Los valores son distintos");
			}
			iRepetir = (int) ValidaLibrary.valida("¿Desea repetir el proceso?\n1- Si\n2- No", 1, 2, 1);
		}

	}
}
