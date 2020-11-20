package model;

public class Ciudad {

	private String cod_ine;
	private String nombre;
	private int tmax;
	private int tmin;
	
	public Ciudad(String cod_ine, String nombre, int tmax, int tmin) {
		super();
		this.cod_ine = cod_ine;
		this.nombre = nombre;
		this.tmax = tmax;
		this.tmin = tmin;
	}

	public String getCod_ine() {
		return cod_ine;
	}

	public void setCod_ine(String cod_ine) {
		this.cod_ine = cod_ine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTmax() {
		return tmax;
	}

	public void setTmax(int tmax) {
		this.tmax = tmax;
	}

	public int getTmin() {
		return tmin;
	}

	public void setTmin(int tmin) {
		this.tmin = tmin;
	}

	@Override
	public String toString() {
		return "				CIUDAD: " + nombre + " [" + tmax + ", " + tmin + "]\n";
	}
	
	
	
}
