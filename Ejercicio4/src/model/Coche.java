package model;

public class Coche {

	private String Marca, Modelo;
	private long Motor;
	private boolean kmO;
	
	public Coche(String marca, String modelo, long motor, boolean kmO) {
		super();
		Marca = marca;
		Modelo = modelo;
		Motor = motor;
		this.kmO = kmO;
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

	public long getMotor() {
		return Motor;
	}

	public void setMotor(long motor) {
		Motor = motor;
	}

	public boolean isKmO() {
		return kmO;
	}

	public void setKmO(boolean kmO) {
		this.kmO = kmO;
	}

	@Override
	public String toString() {
		return "Coche [Marca=" + Marca + ", Modelo=" + Modelo + ", Motor=" + Motor + ", kmO=" + kmO + "]";
	}
	
	
	
}
