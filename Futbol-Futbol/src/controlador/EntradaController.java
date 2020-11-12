package controlador;

import modelo.Entrada;


public class EntradaController implements InterfaceFutbol<Entrada>{

	private Entrada aEntrada[];
	private int iContEntrada;
	
	public EntradaController(int numEntradas) {
		aEntrada = new Entrada[numEntradas];
		setiContEntrada(0);
	}
	
	public Entrada[] getaEntrada() {
		return aEntrada;
	}
	public void setaEntrada(Entrada[] aEntrada) {
		this.aEntrada = aEntrada;
	}
	public int getiContEntrada() {
		return iContEntrada;
	}
	public void setiContEntrada(int iContEntrada) {
		this.iContEntrada = iContEntrada;
	}
	
	public int searchPosition(Entrada oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aEntrada.length) {
			if (oObjeto.equals(aEntrada[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Entrada searchObject(Entrada oObjeto) {
		Entrada oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aEntrada.length) {
			if (oObjeto.equals(aEntrada[iContador])) {
				oDevolver = aEntrada[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Entrada oObjeto) {
		int iRes=0;
		boolean bExito = false;
		if (iContEntrada < aEntrada.length && searchPosition(oObjeto) == -1) {
			aEntrada[iContEntrada] = oObjeto;
			setiContEntrada(iContEntrada + 1);
			bExito = true;
		}if(bExito) {
			String sql = "INSERT INTO entrada VALUES (" +oObjeto.getiId_Entrada() + "," +oObjeto.getiPuerta() +
					"," + oObjeto.getiAsiento() + "," +oObjeto.getiFila() + ")";
			iRes= ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Entrada read(Entrada oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Entrada oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aEntrada[iPosicion] = oObjeto;
			bExito = true;
		}if(bExito) {
			String sql = "UPDATE entrada ";
			sql += "SET Puerta = " +oObjeto.getiPuerta()+ ",Asiento = " +oObjeto.getiAsiento()+ ",Fila = " +oObjeto.getiFila();
			sql += "WHERE Id_Entrada = " +oObjeto.getiId_Entrada();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Entrada oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aEntrada.length; iCont++) {
				aEntrada[iCont - 1] = aEntrada[iCont];
			}
			aEntrada[aEntrada.length - 1] = null;
			setiContEntrada(iContEntrada - 1);
			bExito = true;
		}if(bExito) {
			String sql = "DELETE FROM entrada WHERE Id_Entrada = " +oObjeto.getiId_Entrada();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContEntrada == 0) {
			sResultado = "No hay Entrada registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContEntrada; iCont++) {
				sResultado += aEntrada[iCont] + "\n";
			}
		}
		return sResultado;
	}
}
