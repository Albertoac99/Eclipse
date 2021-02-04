package model;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Pared implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String tipoPared;
	private String color;
	
	public Pared() {
	}
	public Pared(String tipoPared, String color) {
		this.tipoPared = tipoPared;
		this.color = color;
	}
	public String getTipoPared() {
		return tipoPared;
	}
	public void setTipoPared(String tipoPared) {
		this.tipoPared = tipoPared;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Pared [tipoPared=" + tipoPared + ", color=" + color + "]";
	}
	

}
