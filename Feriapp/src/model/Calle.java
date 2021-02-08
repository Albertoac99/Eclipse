package model;

public class Calle {
	
	String nombreCalle;

	public Calle(String nombreCalle) {
		super();
		this.nombreCalle = nombreCalle;
	}

	public String getNombreCalle() {
		return nombreCalle;
	}

	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}

	@Override
	public String toString() {
		return "Calle [nombreCalle=" + nombreCalle + "]";
	}

}
