import java.util.ArrayList;

public class B2_E4 {

    public static void main (String[] args) {
	
	final int NUMTHREADS = 5;	
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;
	
	String sCadena = "Hola mundo.";
	
	// Creando hilos
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    System.out.println("Creando el hilo "+iContador+".");
	    listThreads.add(new Thread(new Hilo(sCadena,iContador)));
	}
	
	// Iniciando los hilos
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    listThreads.get(iContador).start();
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
    }
}
