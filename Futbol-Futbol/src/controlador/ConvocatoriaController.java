package controlador;

import modelo.Convocatoria;

public class ConvocatoriaController implements InterfaceFutbol<Convocatoria>{

	private Convocatoria aConvocatoria[];
	private int iContConvocatoria;
	
	public ConvocatoriaController(int numConvocatorias) {
		aConvocatoria = new Convocatoria[numConvocatorias];
		setiContConvocatoria(0);
	}
	
	public Convocatoria[] getaConvocatoria() {
		return aConvocatoria;
	}
	public void setaConvocatoria(Convocatoria[] aConvocatoria) {
		this.aConvocatoria = aConvocatoria;
	}
	public int getiContConvocatoria() {
		return iContConvocatoria;
	}
	public void setiContConvocatoria(int iContConvocatoria) {
		this.iContConvocatoria = iContConvocatoria;
	}
	
	public int searchPosition(Convocatoria oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aConvocatoria.length) {
			if (oObjeto.equals(aConvocatoria[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Convocatoria searchObject(Convocatoria oObjeto) {
		Convocatoria oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aConvocatoria.length) {
			if (oObjeto.equals(aConvocatoria[iContador])) {
				oDevolver = aConvocatoria[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Convocatoria oObjeto) {
		int iRes=0;
		boolean bExito = false;
		if (iContConvocatoria < aConvocatoria.length && searchPosition(oObjeto) == -1) {
			aConvocatoria[iContConvocatoria] = oObjeto;
			setiContConvocatoria(iContConvocatoria + 1);
			bExito = true;
		}if(bExito) {
			String sql = "INSERT INTO convocatoria VALUES (" +oObjeto.getiId_Convocatoria() +
					"," + oObjeto.getsOnce() + ")";
			iRes = ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Convocatoria read(Convocatoria oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Convocatoria oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aConvocatoria[iPosicion] = oObjeto;
			bExito = true;
		}if(bExito) {
			String sql = "UPDATE convocatoria ";
			sql += "SET Once = " +oObjeto.getsOnce();
			sql += "WHERE Id_Convocatoria =" +oObjeto.getiId_Convocatoria();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Convocatoria oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aConvocatoria.length; iCont++) {
				aConvocatoria[iCont - 1] = aConvocatoria[iCont];
			}
			aConvocatoria[aConvocatoria.length - 1] = null;
			setiContConvocatoria(iContConvocatoria - 1);
			bExito = true;
		}if(bExito) {
			String sql = "DELETE FROM convocatoria WHERE Id_Convocatoria = " +oObjeto.getiId_Convocatoria();
			iRes= ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContConvocatoria == 0) {
			sResultado = "No hay Convocatoria registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContConvocatoria; iCont++) {
				sResultado += aConvocatoria[iCont] + "\n";
			}
		}
		return sResultado;
	}
	
}
