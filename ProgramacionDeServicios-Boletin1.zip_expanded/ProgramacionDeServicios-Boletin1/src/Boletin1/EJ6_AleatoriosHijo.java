package Boletin1;

import java.util.Random;

public class EJ6_AleatoriosHijo {

	public static void main(String[] args) {
		int max = 10, min = 0, iValor; 
		Random r = new Random();
		
		iValor = r.nextInt(max-min+1);
		System.out.println("Este es el valor del hijo --> " +iValor);
		
		System.exit(iValor);

	}
}
