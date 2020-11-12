import java.io.Serializable;

public class Persona implements Serializable{

	private String sNombre;
	private int iEdad;
	private static final long serialVersionUID = 1L;
	
	public Persona(String sNombre, int iEdad) {
		super();
		this.sNombre = sNombre;
		this.iEdad = iEdad;
	}


	public String getsNombre() {
		return sNombre;
	}


	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}


	public int getiEdad() {
		return iEdad;
	}


	public void setiEdad(int iEdad) {
		this.iEdad = iEdad;
	}


	@Override
	public String toString() {
		return "Persona [sNombre=" + sNombre + ", iEdad=" + iEdad + "]";
	}
	
	
	
}
