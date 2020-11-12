package modelo;

public class Carnet implements ICarnet{

	private int iNumero_Abonado;
	private int iTemporada;
	
	public Carnet (int iNumero_Abonado,int iTemporada) {
		setiNumero_Abonado(iNumero_Abonado);
		setiTemporada(iTemporada);		
	}
	
	public Carnet (int iNumero_Abonado) {
		setiNumero_Abonado(iNumero_Abonado);
		setiTemporada(0);
	}
	
	@Override
	public int getiNumero_Abonado() {
		return iNumero_Abonado;
	}
	private boolean setiNumero_Abonado(int iNumero_Abonado) {
		boolean bExito = false;
		if(iNumero_Abonado>0 && iNumero_Abonado<10000) {
			this.iNumero_Abonado = iNumero_Abonado;
			bExito = true;
		}
		return bExito;
	}
	@Override
	public int getiTemporada() {
		return iTemporada;
	}
	@Override
	public boolean setiTemporada(int iTemporada) {
		boolean bExito = false;
		if(iTemporada>2010 && iTemporada<2040) {
		this.iTemporada = iTemporada;
		bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Número de abonados: " + getiNumero_Abonado() + "\n";
		sResultado += "Temporada: " + getiTemporada() + "\n";

		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Carnet otro = (Carnet) obj;
		if (this != null && otro != null && this.getiNumero_Abonado()==otro.getiNumero_Abonado()) {
			bIgual = true;
		}
		return bIgual;
	}

	
	
	
}
