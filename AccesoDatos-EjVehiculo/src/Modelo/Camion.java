package Modelo;

public class Camion extends Vehiculo{

	private int Ejes;
	private long Volumen;
	
	public Camion(String marca, String modelo, int ejes, long volumen) {
		super(marca, modelo);
		Ejes = ejes;
		Volumen = volumen;
	}

	public int getEjes() {
		return Ejes;
	}

	public void setEjes(int ejes) {
		Ejes = ejes;
	}

	public long getVolumen() {
		return Volumen;
	}

	public void setVolumen(long volumen) {
		Volumen = volumen;
	}

	@Override
	public String toString() {
		return "Camion [Ejes=" + Ejes + ", Volumen=" + Volumen + "]";
	}
	
	
}
