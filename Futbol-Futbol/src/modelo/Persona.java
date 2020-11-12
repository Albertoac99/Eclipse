package modelo;



public class Persona implements IPersona{

	protected String sDNI;
	protected String sNombre, sApellido;
	
	
	public Persona(String sDNI, String sNombre, String sApellido) {
		setsDNI(sDNI);
		setsNombre(sNombre);
		setsApellido(sApellido);
		
	}
	
	public Persona() {
	}
	@Override
	public String getsDNI() {
		return sDNI;
	}
	private boolean setsDNI(String sDNI) {
		boolean bExito = false;
		if(sDNI.length()==9) {
		this.sDNI = sDNI;
		bExito = true;
		}
		return bExito;
	}
	@Override
	public String getsNombre() {
		return sNombre;
	}
	@Override
	public boolean setsNombre(String sNombre) {
		boolean bExito=false;
		if(sNombre.length()>0 && sNombre.length()<100) {
		this.sNombre = sNombre;
		bExito = true;
		}
		return bExito;
	}
	@Override
	public String getsApellido() {
		return sApellido;
	}
	@Override
	public boolean setsApellido(String sApellido) {
		boolean bExito=false;
		if(sApellido.length()>0 && sApellido.length()<100) {
			this.sApellido = sApellido;
			bExito = true;
		}
		return bExito;
		
	}
	

	
	
	
	
	
	
	
	
}
