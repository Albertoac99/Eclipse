
public class Hilo1 implements Runnable {

    private int iContador;
    
    public Hilo1(int iContador) {
	setiContador(iContador);
    }   
    
    public int getiContador () {
        return iContador;
    }
    
    public void setiContador (int iContador) {
        this.iContador = iContador;
    }
    
    @Override
    public void run() {	
	
	for(int iCont=0;iCont<10;iCont++) {
	    iContador++;
	    System.out.println("HIJO:: Valor del contador: "+iContador);
	    
	    //Esperate 2 segundos por cada elefante.
	    try {
		Thread.sleep(2000);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
	
    }
}
