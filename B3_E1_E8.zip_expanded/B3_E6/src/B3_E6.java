import java.util.ArrayList;

public class B3_E6 {

    public class Control {
	private volatile int iNumero;

	public int getiNumero () {
	    return iNumero;
	}

	public void setiNumero (int iNumero) {
	    this.iNumero = iNumero;
	}
    }

    final Control control = new Control();

    public class Hilo implements Runnable {

	@Override
	public synchronized void run () {
	    for (int iContador = 0; iContador < 20; iContador++) {
		control.setiNumero(control.getiNumero() + 1);
		// ERROR SI METO EL SLEEP: PORQUE?
		/*try {
		    Thread.sleep(100);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}*/
	    }
	}
    }

    private void executeMultiThreading () {

	final int NUMTHREADS = 5;
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;

	control.setiNumero(0);

	// Creando hilos
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    System.out.println("Creando el hilo " + iContador + ".");
	    listThreads.add(new Thread(new Hilo()));
	}

	// Iniciando los hilos
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    listThreads.get(iContador).start();
	}

	// Padre también suma
	// PARCHEO... ¿SEGURO QUE ESTO ES ASÍ?
	for (iContador = 0; iContador < 20; iContador++) {
	    control.setiNumero(control.getiNumero() + 1);
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

	System.out.println("Numero: " + control.getiNumero());
    }

    public static void main (String[] args) {

	try {
	    B3_E6 oB3E6 = new B3_E6();
	    oB3E6.executeMultiThreading();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
