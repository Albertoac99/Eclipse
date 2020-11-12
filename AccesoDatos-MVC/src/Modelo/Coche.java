package Modelo;

import java.io.Serializable;

public class Coche implements Serializable{

	private static final long serialVersionUID = 1L;
	private String Marca, Modelo;
	private int Potencia;
	
	
	public Coche(String marca, String modelo, int potencia) {
		super();
		Marca = marca;
		Modelo = modelo;
		Potencia = potencia;
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

	public int getPotencia() {
		return Potencia;
	}

	public void setPotencia(int potencia) {
		Potencia = potencia;
	}

	@Override
	public String toString() {
		return "Coche [Marca=" + Marca + ", Modelo=" + Modelo + ", Potencia=" + Potencia + "]";
	}
	
	
	
}
