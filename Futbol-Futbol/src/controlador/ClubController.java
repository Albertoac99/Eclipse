package controlador;

import modelo.Club;

public class ClubController implements InterfaceFutbol<Club>{

	private Club aClub[];
	private int iContClub;
	
	public ClubController(int numClubs) {
		aClub = new Club[numClubs];
		setiContClub(0);
	}
	
	public Club[] getaClub() {
		return aClub;
	}
	public void setaClub(Club[] aClub) {
		this.aClub = aClub;
	}
	public int getiContClub() {
		return iContClub;
	}
	public void setiContClub(int iContClub) {
		this.iContClub = iContClub;
	}
	
	public int searchPosition(Club oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aClub.length) {
			if (oObjeto.equals(aClub[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Club searchObject(Club oObjeto) {
		Club oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aClub.length) {
			if (oObjeto.equals(aClub[iContador])) {
				oDevolver = aClub[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Club oObjeto) {
		int iRes=0;
		boolean bExito = false;
		if (iContClub < aClub.length && searchPosition(oObjeto) == -1) {
			aClub[iContClub] = oObjeto;
			setiContClub(iContClub + 1);
			bExito = true;
		}
		if(bExito) {
			String sql = "INSERT INTO club VALUES (" +oObjeto.getsNombre_Club() +
					"," +oObjeto.getiNumero_Abonados()+ ")";
			iRes= ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Club read(Club oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Club oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aClub[iPosicion] = oObjeto;
			bExito = true;
		}if(bExito) {
			String sql = "UPDATE club";
			sql += "SET Numero_Abonados = " +oObjeto.getiNumero_Abonados();
			sql += "WHERE Nombre_Club = " +oObjeto.getsNombre_Club();
			iRes = ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Club oObjeto) {
		int iRes =0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aClub.length; iCont++) {
				aClub[iCont - 1] = aClub[iCont];
			}
			aClub[aClub.length - 1] = null;
			setiContClub(iContClub - 1);
			bExito = true;
		}if (bExito) {
			String sql = "DELTE FROM club WHERE Nombre_Club=" +oObjeto.getsNombre_Club();
			iRes= ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContClub == 0) {
			sResultado = "No hay Club registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContClub; iCont++) {
				sResultado += aClub[iCont] + "\n";
			}
		}
		return sResultado;
	}
	
}
