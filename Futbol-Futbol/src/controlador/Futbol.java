package controlador;

public class Futbol {

	public CampoController aCampo;
	public CarnetController aCarnet;
	public ClubController aClub;
	public ConvocatoriaController aConvocatoria;
	public EntradaController aEntrada;
	public JugadorController aJugador;
	public SocioController aSocio;
	public Venta_EntradaController aVentaEntrada;
	String sNombre;
	
	public Futbol (String sNombre, int iMaxCampo, int iMaxCarnet, int iMaxClub, int iMaxConvocatoria, int iMaxEntrada, int iMaxJugador, int iMaxSocio, int iMaxVentaEntrada) {
		
		aCampo = new CampoController(iMaxCampo);
		aCarnet = new CarnetController(iMaxCarnet);
		aClub = new ClubController(iMaxClub);
		aConvocatoria = new ConvocatoriaController(iMaxConvocatoria);
		aEntrada = new EntradaController(iMaxEntrada);
		aJugador = new JugadorController(iMaxJugador);
		aSocio = new SocioController(iMaxSocio);
		aVentaEntrada= new Venta_EntradaController(iMaxVentaEntrada);
		setsNombre(sNombre);
	}
	
	public CampoController getaCampo() {
		return aCampo;
	}
	public void setaCampo(CampoController aCampo) {
		this.aCampo = aCampo;
	}
	public CarnetController getaCarnet() {
		return aCarnet;
	}
	public void setaCarnet(CarnetController aCarnet) {
		this.aCarnet = aCarnet;
	}
	public ClubController getaClub() {
		return aClub;
	}
	public void setaClub(ClubController aClub) {
		this.aClub = aClub;
	}
	public ConvocatoriaController getaConvocatoria() {
		return aConvocatoria;
	}
	public void setaConvocatoria(ConvocatoriaController aConvocatoria) {
		this.aConvocatoria = aConvocatoria;
	}
	public EntradaController getaEntrada() {
		return aEntrada;
	}
	public void setaEntrada(EntradaController aEntrada) {
		this.aEntrada = aEntrada;
	}
	public JugadorController getaJugador() {
		return aJugador;
	}
	public void setaJugador(JugadorController aJugador) {
		this.aJugador = aJugador;
	}
	public SocioController getaSocio() {
		return aSocio;
	}
	public void setaSocio(SocioController aSocio) {
		this.aSocio = aSocio;
	}
	public Venta_EntradaController getaVentaEntrada() {
		return aVentaEntrada;
	}
	public void setaVentaEntrada(Venta_EntradaController aVentaEntrada) {
		this.aVentaEntrada = aVentaEntrada;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	
	
}
