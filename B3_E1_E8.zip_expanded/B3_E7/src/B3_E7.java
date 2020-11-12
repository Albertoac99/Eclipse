import java.util.ArrayList;

public class B3_E7 {

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

	public Hilo(int iId) {
	    setiId(iId);
	}

	public int getiId () {
	    return iId;
	}

	public void setiId (int iId) {
	    this.iId = iId;
	}

	@Override
	public synchronized void run () {
	    System.out.println("Hilo "+this.getiId()+" se esta ejecutando.");
	    
	    if (this.getiId() == 0) { // Thread A		
		try {
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
	    } else { // Thread B
		
		try {
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
	    }
	}
    }

    private void executeMultiThreading () {

	final int NUMTHREADS = 2;
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;

	control.setiContador(0);

	// Creando hilos
	for (iContador = 0; iContador < NUMTHREADS; iContador++) {
	    System.out.println("Creando el hilo " + iContador + ".");
	    listThreads.add(new Thread(new Hilo(iContador)));
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
	    B3_E7 oB3E7 = new B3_E7();
	    oB3E7.executeMultiThreading();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
