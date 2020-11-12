package modelo;

public interface IJugador {

	public String getsApodo();
	public int getiPosicion();
	public boolean setiPosicion(int iPosicion);
	public int getiDorsal();
	public boolean setiDorsal(int iDorsal);
	public String toString();
	public boolean equals(Object obj);
	
}
