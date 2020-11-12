package modelo;

public class Campo implements ICampo{

	private String sNombre_Campo;
	private int iCapacidad;
	
	public Campo(String sNombre_Campo, int iCapacidad) {
		setsNombre_Campo(sNombre_Campo);
		setiCapacidad(iCapacidad);
	}
	
	public Campo(String sNombre_Campo) {
		setsNombre_Campo(sNombre_Campo);
		setiCapacidad(0);
	}
	
	@Override
	public String getsNombre_Campo() {
		return sNombre_Campo;
	}
	private boolean setsNombre_Campo(String sNombre_Campo) {
		boolean bExito = false;
		if(sNombre_Campo.length()<50 && sNombre_Campo.length()>0) {
		this.sNombre_Campo = sNombre_Campo;
		bExito = true;
		}
		return bExito;
	}
	@Override
	public int getiCapacidad() {
		return iCapacidad;
	}
	@Override
	public boolean setiCapacidad(int iCapacidad) {
		boolean bExito = false;
		if(iCapacidad>0) {
		this.iCapacidad = iCapacidad;
		bExito = true;
		}
		return bExito;
	}
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Nombre: " + getsNombre_Campo() + "\n";
		sResultado += "Capacidad: " + getiCapacidad() + "\n";

		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Campo otro = (Campo) obj;
		if (this != null && otro != null && this.getsNombre_Campo().equals(otro.getsNombre_Campo())) {
			bIgual = true;
		}
		return bIgual;
	}

	
}
