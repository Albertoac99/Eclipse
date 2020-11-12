
public class Hilo implements Runnable {

    private String sCadena;
    private int iId;

    public Hilo(String sCadena, int iId) {
	setsCadena(sCadena);
	setiId(iId);
    }

    public String getsCadena () {
        return sCadena;
    }

    public void setsCadena (String sCadena) {
        this.sCadena = sCadena;
    }

    public int getiId () {
        return iId;
    }

    public void setiId (int iId) {
        this.iId = iId;
    }

    @Override
    public void run () {
	System.out.println("Hilo "+iId+" con cadena: "+sCadena);
    }
}
