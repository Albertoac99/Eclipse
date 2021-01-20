package model;

public class Coche {
	
	private Integer idCoche, potencia;
	private String marca, modelo;
	
	public Coche() {
	}

	public Coche(String marca, String modelo, Integer potencia) {
		this.potencia = potencia;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Integer getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(Integer idCoche) {
		this.idCoche = idCoche;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Coche [idCoche=" + idCoche + ", potencia=" + potencia + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	

}
