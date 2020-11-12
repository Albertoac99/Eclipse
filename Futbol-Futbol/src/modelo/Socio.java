package modelo;


public class Socio extends Persona implements ISocio{

	private String sNombre_Usuario;
	private float fMonedero;
	private String sContrasenya;
	
	public Socio(String sNombre, String sDNI, String sApellido,  String sNombre_Usuario, float fMonedero, String sContrasenya) {
		super( sDNI,  sNombre,  sApellido);
		setsNombre_Usuario(sNombre_Usuario);
		setfMonedero(fMonedero);
		setsContrasenya(sContrasenya);
	}
	
	public Socio(String sNombre_Usuario) {
		
		setsNombre_Usuario(sNombre_Usuario);
		setfMonedero(0);
		setsContrasenya("0");
		
	}
	
	public Socio() {
		setsNombre_Usuario(sNombre_Usuario);
		setfMonedero(fMonedero);
		setsContrasenya(sContrasenya);
	}
	
	@Override
	public String getsNombre_Usuario() {
		return sNombre_Usuario;
	}
	private boolean setsNombre_Usuario(String sNombre_Usuario) {
		boolean bExito=false;
		if(sNombre_Usuario.length()>0 && sNombre_Usuario.length()<100) {
		this.sNombre_Usuario = sNombre_Usuario;
		bExito=true;
	}
		return bExito;
	}
		
	@Override
	public float getfMonedero() {
		return fMonedero;
	}
	@Override
	public boolean setfMonedero(float fMonedero) {
		boolean bExito=false;
		if(fMonedero>=0 && fMonedero<50000) {
		this.fMonedero = fMonedero;
		bExito = true;
		}
		return bExito;
	}
	@Override
	public String getsContrasenya() {
		return sContrasenya;
	}
	@Override
	public boolean setsContrasenya(String sContrasenya) {
		boolean  bExito = false;
		if(sContrasenya.length()>0 && sContrasenya.length()<100) {
		this.sContrasenya = sContrasenya;
		bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Nombrede usuario: " + getsNombre_Usuario() + "\n";
		sResultado += "Monedero: " + getfMonedero() + "\n";
		sResultado += "Conrasenya: " + getsContrasenya() + "\n";
		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Socio otro = (Socio) obj;
		if (this != null && otro != null && this.getsNombre_Usuario()==otro.getsNombre_Usuario()) {
			bIgual = true;
		}
		return bIgual;
	}
	
	
	
}
