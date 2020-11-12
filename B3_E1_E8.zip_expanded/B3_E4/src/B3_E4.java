import java.util.ArrayList;

public class B3_E4 {

    public class Control {
	private volatile int iContador;
	private volatile String sCadena;

	public int getiContador () {
	    return iContador;
	}

	public void setiContador (int iContador) {
	    this.iContador = iContador;
	}

	public String getsCadena () {
	    return sCadena;
	}

	public void setsCadena (String sCadena) {
	    this.sCadena = sCadena;
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
	public void run () {
	    System.out.println("Hilo "+iId+" con cadena: "+control.getsCadena());
	}
    }

    private void executeMultiThreading () {

	final int NUMTHREADS = 5;
	ArrayList<Thread> listThreads = new ArrayList<Thread>();
	int iContador;

	control.setsCadena("Hola mundo");

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
    }

    public static void main (String[] args) {

	try {
	    B3_E4 oB3E4 = new B3_E4();
	    oB3E4.executeMultiThreading();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
