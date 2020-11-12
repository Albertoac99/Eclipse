
public class B2_E2 {

    public static void main (String[] args) {
	
	int iContador = 0;
	System.out.println("PADRE:: Valor del contador antes del start(): "+iContador);
	
	Hilo1 h1 = new Hilo1(iContador);
	Thread t1 = new Thread(h1);
	t1.start();
	
	System.out.println("PADRE:: Despues de start(): "+h1.getiContador());
	
	// Duermo 4 segundos
	try {
	    Thread.sleep(4000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println("PADRE:: Despues de dormir 4 segundos(): "+h1.getiContador());
	
	try{	    
	    t1.join();
	} catch(InterruptedException ex) {
	    System.out.println(ex.getMessage());
	}
	
	System.out.println("PADRE:: Valor del contador despues del join(): "+h1.getiContador());
	
	iContador = h1.getiContador();
    }
}
