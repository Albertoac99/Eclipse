package modelo;

public interface IEntrada {

	public int getiId_Entrada();
	public int getiPuerta();
	public boolean setiPuerta(int iPuerta);
	public int getiAsiento();
	public boolean setiAsiento(int iAsiento);
	public int getiFila();
	public boolean setiFila(int iFila);
	public String toString();
	public boolean equals(Object obj);
}
