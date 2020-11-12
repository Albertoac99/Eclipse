package modelo;

public interface ISocio {

	public String getsNombre_Usuario();
	public float getfMonedero();
	public boolean setfMonedero(float fMonedero);
	public String getsContrasenya();
	public boolean setsContrasenya(String sContrasenya);
	public String toString();
	public boolean equals(Object obj);
}
