package model;

import java.io.Serializable;

public class Boton implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String texto;
	private Double pulsaVida;
	
	public Boton(int id, String texto, Double pulsaVida) {
		super();
		this.id = id;
		this.texto = texto;
		this.pulsaVida = pulsaVida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Double getpulsaVida() {
		return pulsaVida;
	}

	public void setpulsaVida(Double pulsaVida) {
		this.pulsaVida = pulsaVida;
	}

	@Override
	public String toString() {
		return "Boton [id=" + id + ", texto=" + texto + ", numPulsaciones=" + pulsaVida + "]";
	}
	
	

}
