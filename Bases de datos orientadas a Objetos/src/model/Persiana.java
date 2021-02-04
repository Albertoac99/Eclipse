package model;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Persiana implements Serializable{

	private static final long serialVersionUID = 1L;
	private int ancho;
	private int largo;
	private String color;
	public Persiana() {
	}
	public Persiana(int ancho, int largo, String color) {
		this.ancho = ancho;
		this.largo = largo;
		this.color = color;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Persiana [ancho=" + ancho + ", largo=" + largo + ", color=" + color + "]";
	}
	
	
	
}
