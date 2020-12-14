import java.util.ArrayList;
import java.util.concurrent.*;

public class B3_EJ8 {

    public class Control {
	private volatile int iContador = 0;

	public int getiContador () {
	    return iContador;
	}

	public void setiContador (int iContador) {
	    this.iContador = iContador;
	}
    }

    final Control control = new Control();

    public class Hilo implements Runnable {

	private int iId;
	private Semaphore oSemaforo;

	public Hilo(Semaphore oSemaforo, int iId) {
	    setiId(iId);
	    setoSemaforo(oSemaforo);
	}

	public int getiId () {
	    return iId;
	}

	public void setiId (int iId) {
	    this.iId = iId;
	}

	public Semaphore getoSemaforo () {
	    return oSemaforo;
	}

	public void setoSemaforo (Semaphore oSemaforo) {
	    this.oSemaforo = oSemaforo;
	}

	@Override
	public synchronized void run () {
	    System.out.println("Hilo " + this.getiId() + " accede.");

	    if (this.getiId() == 0) { // Thread A
		try {

		    // Intento bloquear cuando haya un semaforo disponible.
		    oSemaforo.acquire();

		    System.out
			    .println("El hilo " + this.getiId() + " pasa a ejecutarse por los permisos del semaforo.");
		    for (int iCont = 0; iCont < 5; iCont++) {
			control.setiContador(control.getiContador() + 1);
			System.out.println("El hilo " + this.getiId() + " ha modificado el valor iContador a: "
				+ control.getiContador());

			// Duerme 10 milisegundos
			Thread.sleep(10);
		    }
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

		// Libero el semaforo para que otros puedan utilizar el procesador.
		oSemaforo.release();

	    } else { // Thread B

		try {

		    // Intento bloquear cuando haya un semaforo disponible.
		    oSemaforo.acquire();

		    for (int iCont = 0; iCont < 5; iCont++) {
			control.setiContador(control.getiContador() - 1);
			System.out.println("El hilo " + this.getiId() + " ha modificado el valor iContador a: "
				+ control.getiContador());

			// Duerme 10 milisegundos
			Thread.sleep(10);
		    }
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

		// Libero el semaforo para que otros puedan utilizar el procesador.
		oSemaforo.release();
	    }
	}
    }

    private void executeMultiThreading () {

	final int NUMTHREADS = 2;
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;

	control.setiContador(0);
	Semaphore oSemaforo = new Semaphore(1);

	// Creando hilos
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    System.out.println("Creando el hilo " + iContador + ".");
	    listThreads.add(new Thread(new Hilo(oSemaforo, iContador)));
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

	System.out.println("Numero: " + control.getiContador());
    }

    public static void main (String[] args) {

	try {
	    B3_EJ8 oB3E8 = new B3_EJ8();
	    oB3E8.executeMultiThreading();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
