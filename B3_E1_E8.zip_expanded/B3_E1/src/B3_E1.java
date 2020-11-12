public class B3_E1 {

    public class Control {
	private volatile String sCadena;

	public String getsCadena () {
	    return sCadena;
	}

	public void setsCadena (String sCadena) {
	    this.sCadena = sCadena;
	}
    }
    final Control control = new Control();
    
    

    public class Hilo implements Runnable {

	@Override
	public void run () {
	    System.out.println("HIJO: He recibido del padre el siguiente valor: " + control.getsCadena());
	    System.out.println("HIJO: Ahora voy a modificar yo esa variable y le voy a poner 'Adios': " + control.getsCadena());
	    control.setsCadena("Adios");
	}
    }
    
    
    
    private void executeMultiThreading() {
	
	System.out.println("PADRE: Hola que tal, estás en el padre.");
	System.out.println("PADRE: Voy a modificar la variable cadena y le voy a poner 'ola k ase'.");	
	control.setsCadena("ola k ase");
	
	Thread t1 = new Thread(new Hilo());
	t1.start();

	try {
	    t1.join();
	} catch (InterruptedException ex) {
	    System.out.println(ex.getMessage());
	}
	
	System.out.println("PADRE: Ya se ha terminado de ejecutar el hijo, he recibido del hijo lo siguiente: " + control.getsCadena());
    }

    public static void main (String[] args) {		
	
	try{
	    B3_E1 oB3E1 = new B3_E1();
	    oB3E1.executeMultiThreading();
	} catch(Exception e) {
	    System.out.println(e.getMessage());
	}	
    }
}
