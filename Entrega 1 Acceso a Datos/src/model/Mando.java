package model;

import java.io.Serializable;
import java.util.List;

public class Mando implements Serializable{
	
	static final long serialVersionUID = 1L;
	private int id;
	private String modelo;
	private List<Boton> botones;
	
	public Mando(int id, String modelo, List<Boton> botones) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.botones = botones;
	}
	
		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Boton> getBotones() {
		return botones;
	}

	public void setBotones(List<Boton> botones) {
		this.botones = botones;
	}

	@Override
	public String toString() {
		return "Mando [id=" + id + ", modelo=" + modelo + ", botones=" + botones + "]";
	}

	
	

}
