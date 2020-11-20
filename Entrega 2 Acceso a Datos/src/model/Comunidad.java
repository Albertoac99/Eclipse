package model;

import java.util.List;

public class Comunidad {
	
	private String id;
	private String nombre;
	private List<Provincia> provincias;
	
	public Comunidad(String id, String nombre, List<Provincia> provincias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincias = provincias;
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

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	private String provincias() {
		String resultado="";
		
		for(Provincia p : provincias) {
			resultado+= p.toString();
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		
		return "COMUNIDAD: " + nombre + "\n" + provincias();
	}
	
	

}
