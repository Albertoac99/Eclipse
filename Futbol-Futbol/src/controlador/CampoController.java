package controlador;

import modelo.Campo;

public class CampoController implements InterfaceFutbol<Campo>{

	private Campo aCampo[];
	private int iContCampo;
	
	public CampoController(int numCampos) {
		aCampo = new Campo[numCampos];
		setiContCampo(0);
	}
	
	public Campo[] getaCampo() {
		return aCampo;
	}
	public void setaCampo(Campo[] aCampo) {
		this.aCampo = aCampo;
	}
	public int getiContCampo() {
		return iContCampo;
	}
	public void setiContCampo(int iContCampo) {
		this.iContCampo = iContCampo;
	}
	
	public int searchPosition(Campo oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aCampo.length) {
			if (oObjeto.equals(aCampo[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Campo searchObject(Campo oObjeto) {
		Campo oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aCampo.length) {
			if (oObjeto.equals(aCampo[iContador])) {
				oDevolver = aCampo[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Campo oObjeto) {
		boolean bExito = false;
		int iRes = 0;
		if (iContCampo < aCampo.length && searchPosition(oObjeto) == -1) {
			aCampo[iContCampo] = oObjeto;
			setiContCampo(iContCampo + 1);
			bExito = true;
		}
		if(bExito) {
			String sql = "INSERT INTO campo VALUES (" + oObjeto.getsNombre_Campo() + 
					"," + oObjeto.getiCapacidad() + ")";
			iRes = ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Campo read(Campo oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Campo oObjeto) {
		int iRes = 0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aCampo[iPosicion] = oObjeto;
			bExito = true;
		}
		if(bExito) {
			String sql = "UPDATE campo ";
			sql += "SET Capacidad = " +oObjeto.getiCapacidad();
			sql += "WHERE Nombre_Campo=" +oObjeto.getsNombre_Campo();
			iRes = ConexionDB.executeUpdate(sql);
			
		}
		return bExito;
	}

	
	public boolean delete(Campo oObjeto) {
		int iRes = 0, iCont=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (iCont = iPosicion + 1; iCont < aCampo.length; iCont++) {
				aCampo[iCont - 1] = aCampo[iCont];
			}
			aCampo[aCampo.length - 1] = null;
			setiContCampo(iContCampo - 1);
			bExito = true;
		}
		if(bExito) {
			String sql = "DELETE FROM campo WHERE Nombre_Campo=" + oObjeto.getsNombre_Campo();
			iRes = ConexionDB.executeUpdate(sql);
		
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContCampo == 0) {
			sResultado = "No hay Campo registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContCampo; iCont++) {
				sResultado += aCampo[iCont] + "\n";
			}
		}
		return sResultado;
	}
	
	
}
