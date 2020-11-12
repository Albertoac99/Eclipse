package modelo;

import medac.validaciones.LibFrontend;

public class Venta_Entrada implements IVenta_Entrada{

	private int iId_VentaEntrada;
	private int iTipo_Venta;
	
	public Venta_Entrada(int iId_VentaEntrada, int iTipo_Venta) {
		setiId_VentaEntrada(iId_VentaEntrada);
		setiTipo_Venta(iTipo_Venta);
	}
	
	public Venta_Entrada(int iId_VentaEntrada) {
		setiId_VentaEntrada(iId_VentaEntrada);
		setiTipo_Venta(0);
	}
	
	@Override
	public int getiId_VentaEntrada() {
		return iId_VentaEntrada;
	}
	private void setiId_VentaEntrada(int iId_VentaEntrada) {
		this.iId_VentaEntrada = iId_VentaEntrada;
	}
	@Override
	public int getiTipo_Venta() {
		return iTipo_Venta;
	}
	@Override
	public boolean setiTipo_Venta(int iTipo_Venta) {
		boolean bExito=false;
		if(iTipo_Venta>0 && iTipo_Venta<3) {
		this.iTipo_Venta = iTipo_Venta;
		bExito=true;
		}
		return bExito;
	}
	
	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Id de la Venta de Entrada: " + getiId_VentaEntrada() + "\n";
		sResultado += "Tipo de Venta: " + Tipo_Venta(iTipo_Venta) + "\n";

		return sResultado;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bIgual = false;
		Venta_Entrada otro = (Venta_Entrada) obj;
		if (this != null && otro != null && this.getiId_VentaEntrada()==otro.getiId_VentaEntrada()) {
			bIgual = true;
		}
		return bIgual;
	}
	
	public String Tipo_Venta(int iTipo_Venta) {
		String sResultado="";
		if(iTipo_Venta==1) {
			sResultado+= "Envío Normal";
		}
		else {
			sResultado+="Envío Expres";
		}
		return sResultado;
	}
	
	
	
	
	
	
	
}
