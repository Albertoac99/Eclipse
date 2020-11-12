
public class B2_E1 {

    public static void main (String[] args) {
	
	System.out.println("Yo soy tu padre.");
	
	Thread t1 = new Thread(new Hilo1("hijo"));
	t1.start();
	
	try{	    
	    t1.join();
	} catch(InterruptedException ex) {
	    System.out.println(ex.getMessage());
	}
    }
}
