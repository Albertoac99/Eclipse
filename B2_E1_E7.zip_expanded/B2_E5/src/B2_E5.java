import java.util.ArrayList;

public class B2_E5 {

    public static void main (String[] args) {
	
	final int NUMTHREADS = 1;	
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;
	
	int iNumero = 0;
	
	
	// Creando hilos
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    System.out.println("Creando el hilo "+iContador+".");
	    listThreads.add(new Thread(new Hilo(iNumero,iContador)));
	}
	
	// Iniciando los hilos
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    listThreads.get(iContador).start();
	}
	
	// Padre también suma
	// ERROR: No podemos acceder a la variable iNumero del objeto Hilo de Thread.
	// ¿Solucion? Crear lista de Objetos Hilos.
	for(iContador=0; iContador < 20 ; iContador++) {
	    Thread t1 = listThreads.get(0);
	    iNumero++;
	}	
	
	// Joins
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    try {
		listThreads.get(iContador).join();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	System.out.println("Numero: "+iNumero);
    }
}
