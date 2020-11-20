package model;

import java.util.List;

public class Provincia {
	
	private String ccaa;
	private String id;
	private String nombre;
	private List<Ciudad> ciudades;
	
	public Provincia(String ccaa, String id, String nombre, List<Ciudad> ciudades) {
		super();
		this.ccaa = ccaa;
		this.id = id;
		this.nombre = nombre;
		this.ciudades = ciudades;
	}

	public String getCcaa() {
		return ccaa;
	}

	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
	private String ciudades() {
		String resultado="";
		
		for(Ciudad c : ciudades) {
			resultado+= c.toString();
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		
		return "		PROVINCIA: " + nombre + "\n" + ciudades();
	}
	
	

}
