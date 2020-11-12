package Modelo;

public class Coche extends Vehiculo{
	
	private boolean SUV;
	private int Potencia;
	
	public Coche(String marca, String modelo, boolean sUV, int potencia) {
		super(marca, modelo);
		SUV = sUV;
		Potencia = potencia;
	}

	public boolean isSUV() {
		return SUV;
	}

	public void setSUV(boolean sUV) {
		SUV = sUV;
	}

	public int getPotencia() {
		return Potencia;
	}

	public void setPotencia(int potencia) {
		Potencia = potencia;
	}

	@Override
	public String toString() {
		return "Coche [SUV=" + SUV + ", Potencia=" + Potencia + "]";
	}
	
	

	
}
