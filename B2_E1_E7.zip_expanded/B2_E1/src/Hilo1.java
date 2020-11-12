
public class Hilo1 implements Runnable {

    private String sCadena;
    
    public Hilo1(String sCadena) {
	this.sCadena = sCadena;
    }
    
    @Override
    public void run() {	
	System.out.println("Yo soy tu "+sCadena);
    }
}
