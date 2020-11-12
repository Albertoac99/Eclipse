package modelo;

public class Convocatoria implements IConvocatoria{

	private int iId_Convocatoria;
	private String sOnce;
	
	public Convocatoria(int iId_Convocatoria, String sOnce) {
		
		setiId_Convocatoria(iId_Convocatoria);
		setsOnce(sOnce);
	}
	
	public Convocatoria(int iId_Convocatoria) {
		setiId_Convocatoria(iId_Convocatoria);
		setsOnce("0");
	}
	
	
	@Override
	public int getiId_Convocatoria() {
		return iId_Convocatoria;
	}

	private boolean setiId_Convocatoria(int iId_Convocatoria) {
		boolean bExito = false;
		if(iId_Convocatoria>0 && iId_Convocatoria<10000) {
			this.iId_Convocatoria = iId_Convocatoria;
			bExito = true;
		}
		return bExito;
	}
	@Override
	public String getsOnce() {
		return sOnce;
	}
	@Override
	public boolean setsOnce(String sOnce) {
		boolean bExito = false;
		if(sOnce.length()>0 && sOnce.length()<100) {
		this.sOnce = sOnce;
		bExito = true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Id de la Convocatoria: " + getiId_Convocatoria() + "\n";
		sResultado += "Once: " + getsOnce() + "\n";

		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Convocatoria otro = (Convocatoria) obj;
		if (this != null && otro != null && this.getiId_Convocatoria()==otro.getiId_Convocatoria()) {
			bIgual = true;
		}
		return bIgual;
	}
	
}
