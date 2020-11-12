package Modelo;

import java.io.Serializable;

public class Vehiculo implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String Marca;
	protected String Modelo;
	
	public Vehiculo(String marca, String modelo) {
		super();
		Marca = marca;
		Modelo = modelo;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehiculo [Marca=" + Marca + ", Modelo=" + Modelo + "]";
	}
	
	
	
	
}
