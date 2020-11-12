package modelo;

public class Entrada implements IEntrada{

	private int iId_Entrada;
	private int iPuerta;
	private int iAsiento;
	private int iFila;
	
	public Entrada(int iId_Entrada,int iPuerta, int iAsiento, int iFila) {
		
		setiId_Entrada(iId_Entrada);
		setiPuerta(iPuerta);
		setiAsiento(iAsiento);
		setiFila(iFila);
	}
	
	public Entrada(int iId_Entrada) {
		setiId_Entrada(iId_Entrada);
		setiPuerta(0);
		setiAsiento(0);
		setiFila(0);
	}
	
	@Override
	public int getiId_Entrada() {
		return iId_Entrada;
	}
	private boolean setiId_Entrada(int iId_Entrada) {
		boolean bExito = false;
		if(iId_Entrada>0 && iId_Entrada<1000) {
			this.iId_Entrada = iId_Entrada;
			bExito=true;
		}
		return bExito;
		
	}
	@Override
	public int getiPuerta() {
		return iPuerta;
	}
	@Override
	public boolean setiPuerta(int iPuerta) {
		boolean bExito = false;
		if(iPuerta>0 && iPuerta<20) {
			this.iPuerta = iPuerta;
			bExito = true;
		}
		return bExito;
	}
	@Override
	public int getiAsiento() {
		return iAsiento;
	}
	@Override
	public boolean setiAsiento(int iAsiento) {
		boolean bExito= false;
		if(iAsiento>0 && iAsiento <300) {
			this.iAsiento = iAsiento;
			bExito = true;
		}
		return bExito;
	}
	@Override
	public int getiFila() {
		return iFila;
	}
	@Override
	public boolean setiFila(int iFila) {
		boolean bExito = false;
		if(iFila>0 && iFila<100) {
			this.iFila = iFila;
			bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Id de la Entrada: " + getiId_Entrada() + "\n";
		sResultado += "Puerta: " + getiPuerta() + "\n";
		sResultado += "Fila: " + getiFila() + "\n";
		sResultado += "Asiento: " + getiAsiento() + "\n";
		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Entrada otro = (Entrada) obj;
		if (this != null && otro != null && this.getiId_Entrada()==otro.getiId_Entrada()) {
			bIgual = true;
		}
		return bIgual;
	}
	
}
