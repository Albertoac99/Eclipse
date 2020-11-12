package controlador;

import modelo.Carnet;

public class CarnetController implements InterfaceFutbol<Carnet>{

	private Carnet aCarnet[];
	private int iContCarnet;
	
	public CarnetController(int numCarnets) {
		aCarnet = new Carnet[numCarnets];
		setiContCarnet(0);
	}
	
	public Carnet[] getaCarnet() {
		return aCarnet;
	}
	public void setaCarnet(Carnet[] aCarnet) {
		this.aCarnet = aCarnet;
	}
	public int getiContCarnet() {
		return iContCarnet;
	}
	public void setiContCarnet(int iContCarnet) {
		this.iContCarnet = iContCarnet;
	}
	
	public int searchPosition(Carnet oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aCarnet.length) {
			if (oObjeto.equals(aCarnet[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Carnet searchObject(Carnet oObjeto) {
		Carnet oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aCarnet.length) {
			if (oObjeto.equals(aCarnet[iContador])) {
				oDevolver = aCarnet[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Carnet oObjeto) {
		int iRes= 0;
		boolean bExito = false;
		if (iContCarnet < aCarnet.length && searchPosition(oObjeto) == -1) {
			aCarnet[iContCarnet] = oObjeto;
			setiContCarnet(iContCarnet + 1);
			bExito = true;
		}
		if(bExito) {
			String sql = "INSERT INTO carnet VALUES (" +oObjeto.getiNumero_Abonado() +
					"," + oObjeto.getiTemporada() + ")";
			iRes = ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Carnet read(Carnet oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Carnet oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aCarnet[iPosicion] = oObjeto;
			bExito = true;
		}
		if(bExito) {
			String sql = "UPDATE carnet ";
			sql += "SET Temporada = " +oObjeto.getiTemporada();
			sql += "WHERE Numero_Abonado =" +oObjeto.getiNumero_Abonado();
			iRes= ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Carnet oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aCarnet.length; iCont++) {
				aCarnet[iCont - 1] = aCarnet[iCont];
			}
			aCarnet[aCarnet.length - 1] = null;
			setiContCarnet(iContCarnet - 1);
			bExito = true;
		}
		if(bExito) {
			String sql = "DELETE FROM carnet WHERE Numero_Abonado=" +oObjeto.getiNumero_Abonado();
			iRes = ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContCarnet == 0) {
			sResultado = "No hay Carnet registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContCarnet; iCont++) {
				sResultado += aCarnet[iCont] + "\n";
			}
		}
		return sResultado;
	}
	
}
