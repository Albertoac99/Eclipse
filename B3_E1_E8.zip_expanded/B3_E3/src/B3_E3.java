import java.util.ArrayList;

public class B3_E3 {

    public class Control {
    }
    final Control control = new Control();

    public class Hilo implements Runnable {

	@Override
	public void run () {
	    System.out.println("Hola mundo.");
	}
    }

    private void executeMultiThreading () {

	final int NUMTHREADS = 5;
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;

	// Creando hilos
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    System.out.println("Creando el hilo " + iContador + ".");
	    listThreads.add(new Thread(new Hilo()));
	}

	// Iniciando los hilos
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    listThreads.get(iContador).start();
	}

	// Joins
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    try {
		listThreads.get(iContador).join();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    public static void main (String[] args) {

	try {
	    B3_E3 oB3E3 = new B3_E3();
	    oB3E3.executeMultiThreading();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
