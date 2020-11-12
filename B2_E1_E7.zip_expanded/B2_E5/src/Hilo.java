
public class Hilo implements Runnable {

    private int iNumero;
    private int iId;

    public Hilo(int iNumero, int iId) {
	setiNumero(iNumero);
	setiId(iId);
    }

    public int getiNumero () {
        return iNumero;
    }

    public void setiNumero (int iNumero) {
        this.iNumero = iNumero;
    }

    public int getiId () {
        return iId;
    }

    public void setiId (int iId) {
        this.iId = iId;
    }

    @Override
    public void run () {	
	for(int iContador = 0; iContador < 20; iContador++) {
	    setiNumero(iNumero+1);
	    try {
		Thread.sleep(1000);
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
