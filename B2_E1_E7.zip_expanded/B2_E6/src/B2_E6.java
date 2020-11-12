import java.util.ArrayList;

public class B2_E6 {

    public static void main (String[] args) {
	
	final int NUMTHREADS = 1;	
	ArrayList<Hilo> listRunnables = new ArrayList<Hilo>();
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;
	
	int iNumero = 0;
	
	// Creando runnables
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    System.out.println("Creando runnable "+iContador+".");
	    listRunnables.add(new Hilo(iNumero,iContador));
	}
	
	// Creando hilos
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    System.out.println("Creando el hilo "+iContador+".");
	    listThreads.add(new Thread(listRunnables.get(iContador)));
	}
	
	// Iniciando los hilos
	for(iContador=0; iContador < NUMTHREADS ; iContador++) {
	    listThreads.get(iContador).start();
	}
	
	// Padre también suma
	// ¿¿PERO NO COMPARTIAN VARIABLES LOS HILOS...??
	for(iContador=0; iContador < 20 ; iContador++) {
	    Hilo h1 = listRunnables.get(0);
	    iNumero = iNumero + h1.getiNumero() + 1;
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
