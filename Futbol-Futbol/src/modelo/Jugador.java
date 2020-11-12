package modelo;


public class Jugador extends Persona implements IJugador{

	private String sApodo;
	private int iPosicion;
	private int iDorsal;
	
	
	
	public Jugador(String sNombre, String sDNI, String sApellido, String sApodo, int iPosicion, int iDorsal) {
		super(sDNI,sNombre,sApellido);
		setsApodo(sApodo);
		setiPosicion(iPosicion);
		setiDorsal(iDorsal);
		
	}
	
	public Jugador(String sApodo) {
		setsApodo(sApodo);
		setiPosicion(0);
		setiDorsal(0);
		
	}
	
	
	@Override
	public String getsApodo() {
		return sApodo;
	}
	private boolean setsApodo(String sApodo) {
		boolean bExito=false;
		if(sApodo.length()>0 && sApodo.length()<100) {
			this.sApodo = sApodo;
			bExito = true;
		}
		return bExito;
	}
	@Override
	public int getiPosicion() {
		return iPosicion;
	}
	@Override
	public boolean setiPosicion(int iPosicion) {
		boolean bExito = false;
		if(iPosicion>0 && iPosicion<5) {
			this.iPosicion = iPosicion;
			bExito= true;
		}
		return bExito;
		
	}
	@Override
	public int getiDorsal() {
		return iDorsal;
	}
	@Override
	public boolean setiDorsal(int iDorsal) {
		boolean bExito = false;
		if(iDorsal>0 && iDorsal <100) {
		this.iDorsal = iDorsal;
		bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Nombre: " + getsNombre() + "\n";
		sResultado += "Apellido: " + getsApellido() + "\n";
		sResultado += "DNI: " + getsDNI() + "\n";
		sResultado += "Apodo: " + getsApodo() + "\n";
		sResultado += "Posicón: "  + Posicion(iPosicion) + "\n";
		sResultado += "Dorsal: " + getiDorsal() + "\n";
		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Jugador otro = (Jugador) obj;
		if (this != null && otro != null && this.getsApodo()==otro.getsApodo()) {
			bIgual = true;
		}
		return bIgual;
	}
	
	public String Posicion(int iPosicion) {
		String sResultado ="";
		if(iPosicion==1) {
			sResultado+= "Portero";
		}
		else if(iPosicion==2) {
			sResultado+= "Defensa";
		}
		else if(iPosicion==3) {
			sResultado+= "Mediocentro";
		}
		else {
			sResultado += "Delantero";
		}
		return sResultado;
		
		
	}
	
	
	
}
