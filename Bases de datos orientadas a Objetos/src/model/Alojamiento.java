package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alojamiento implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private int id;
	private Pared pared;
	private Suelo suelo;
	private Persiana persiana;
	
	public Alojamiento() {
		super();
	}

	public Alojamiento(Pared pared, Suelo suelo, Persiana persiana) {
		this.pared = pared;
		this.suelo = suelo;
		this.persiana = persiana;
	}

	public int getId() {
		return id;
	}

	public Pared getPared() {
		return pared;
	}

	public void setPared(Pared pared) {
		this.pared = pared;
	}

	public Suelo getSuelo() {
		return suelo;
	}

	public void setSuelo(Suelo suelo) {
		this.suelo = suelo;
	}

	public Persiana getPersiana() {
		return persiana;
	}

	public void setPersiana(Persiana persiana) {
		this.persiana = persiana;
	}

	@Override
	public String toString() {
		return "Alojamiento [pared=" + pared + ", suelo=" + suelo + ", persiana=" + persiana + "]";
	}
	
	

}
