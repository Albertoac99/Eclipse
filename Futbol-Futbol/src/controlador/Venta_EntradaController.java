package controlador;

import modelo.Venta_Entrada;

public class Venta_EntradaController implements InterfaceFutbol<Venta_Entrada> {

	private Venta_Entrada aVentaEntrada[];
	private int iContVentaEntrada;
	
	public Venta_EntradaController(int numVenta_Entradas) {
		aVentaEntrada = new Venta_Entrada[numVenta_Entradas];
		setiContVentaEntrada(0);
	}
	
	public Venta_Entrada[] getaVentaEntrada() {
		return aVentaEntrada;
	}
	public void setaVentaEntrada(Venta_Entrada[] aVentaEntrada) {
		this.aVentaEntrada = aVentaEntrada;
	}
	public int getiContVentaEntrada() {
		return iContVentaEntrada;
	}
	public void setiContVentaEntrada(int iContVentaEntrada) {
		this.iContVentaEntrada = iContVentaEntrada;
	}
	
	public int searchPosition(Venta_Entrada oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aVentaEntrada.length) {
			if (oObjeto.equals(aVentaEntrada[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Venta_Entrada searchObject(Venta_Entrada oObjeto) {
		Venta_Entrada oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aVentaEntrada.length) {
			if (oObjeto.equals(aVentaEntrada[iContador])) {
				oDevolver = aVentaEntrada[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Venta_Entrada oObjeto) {
		int iRes=0;
		boolean bExito = false;
		if (iContVentaEntrada < aVentaEntrada.length && searchPosition(oObjeto) == -1) {
			aVentaEntrada[iContVentaEntrada] = oObjeto;
			setiContVentaEntrada(iContVentaEntrada + 1);
			bExito = true;
		}if(bExito) {
			String sql = "INSERT INTO venta_entrada VALUES (" +oObjeto.getiId_VentaEntrada()+","
					+oObjeto.getiTipo_Venta()+")";
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Venta_Entrada read(Venta_Entrada oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Venta_Entrada oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aVentaEntrada[iPosicion] = oObjeto;
			bExito = true;
		}if(bExito) {
			String sql = "UPDATE venta_entrada ";
			sql += "SET Tipo_Venta = " +oObjeto.getiTipo_Venta();
			sql+= "WHERE Id_VentaEntrada = " +oObjeto.getiId_VentaEntrada();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Venta_Entrada oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aVentaEntrada.length; iCont++) {
				aVentaEntrada[iCont - 1] = aVentaEntrada[iCont];
			}
			aVentaEntrada[aVentaEntrada.length - 1] = null;
			setiContVentaEntrada(iContVentaEntrada - 1);
			bExito = true;
		}if(bExito) {
			String sql = "DELETE FROM venta_entrada WHERE Id_VentaEntrada ="+oObjeto.getiId_VentaEntrada();
			iRes= ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContVentaEntrada == 0) {
			sResultado = "No hay VentaEntrada registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContVentaEntrada; iCont++) {
				sResultado += aVentaEntrada[iCont] + "\n";
			}
		}
		return sResultado;
	}
	
}
