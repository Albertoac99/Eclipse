public class B3_E2 {

    public class Control {
	private volatile int iContador;

	public int getiContador () {
	    return iContador;
	}

	public void setiContador (int iContador) {
	    this.iContador = iContador;
	}
    }

    final Control control = new Control();

    public class Hilo implements Runnable {

	@Override
	public void run () {
	    for (int iCont = 0; iCont < 10; iCont++) {
		control.setiContador(control.getiContador() + 1);
		System.out.println("HIJO:: Valor del contador: " + control.getiContador());

		// Esperate 2 segundos por cada elefante.
		try {
		    Thread.sleep(2000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	    }
	}
    }

    private void executeMultiThreading () {

	System.out.println("PADRE:: Valor del contador antes del start(): " + control.getiContador());

	Thread t1 = new Thread(new Hilo());
	t1.start();

	System.out.println("PADRE:: Despues de start(): " + control.getiContador());

	// Duermo 4 segundos
	try {
	    Thread.sleep(4000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println("PADRE:: Despues de dormir 4 segundos(): " + control.getiContador());

	try {
	    t1.join();
	} catch (InterruptedException ex) {
	    System.out.println(ex.getMessage());
	}

	System.out.println("PADRE:: Valor del contador despues del join(): " + control.getiContador());
    }

    public static void main (String[] args) {

	try {
	    B3_E2 oB3E2 = new B3_E2();
	    oB3E2.executeMultiThreading();
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }
}
