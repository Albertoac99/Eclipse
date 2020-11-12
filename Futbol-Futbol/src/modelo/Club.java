package modelo;


public class Club implements IClub{

	private String sNombre_Club; 
	private int iNumero_Abonados;
	
	
	public Club(String sNombre_Club, int iNumero_Abonados) {
		setsNombre_Club(sNombre_Club);
		setiNumero_Abonados(iNumero_Abonados);
	}
	
	public Club(String sNombre_Club) {
		setsNombre_Club(sNombre_Club);
		setiNumero_Abonados(0);
	}
	
	
	@Override
	public String getsNombre_Club() {
		return sNombre_Club;
	}
	private boolean setsNombre_Club(String sNombre_Club) {
		boolean bExito = false;
		if(sNombre_Club.length()>0 && sNombre_Club.length()<100) {
		this.sNombre_Club = sNombre_Club;
		bExito = true;
		}
		return bExito;
	}
	@Override
	public int getiNumero_Abonados() {
		return iNumero_Abonados;
	}
	@Override
	public boolean setiNumero_Abonados(int iNumero_Abonados) {
		boolean bExito = false;
		if(iNumero_Abonados>0 && iNumero_Abonados<40000) {
			this.iNumero_Abonados = iNumero_Abonados;
			bExito = true;
		}
		return bExito;
		
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Nombre del Club: " + getsNombre_Club() + "\n";
		sResultado += "Número de Abonados: " + getiNumero_Abonados() + "\n";

		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Club otro = (Club) obj;
		if (this != null && otro != null && this.getsNombre_Club().equals(otro.getsNombre_Club())) {
			bIgual = true;
		}
		return bIgual;
	}
}
