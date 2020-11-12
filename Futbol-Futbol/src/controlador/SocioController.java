package controlador;

import modelo.Socio;

public class SocioController implements InterfaceFutbol<Socio>{
	
	
	private Socio aSocio[];
	private int iContSocio;
	
	public SocioController(int numSocios) {
		aSocio = new Socio[numSocios];
		setiContSocio(0);
	}
	
	public Socio[] getaSocio() {
		return aSocio;
	}
	public void setaSocio(Socio[] aSocio) {
		this.aSocio = aSocio;
	}
	public int getiContSocio() {
		return iContSocio;
	}
	public void setiContSocio(int iContSocio) {
		this.iContSocio = iContSocio;
	}
	
	public int searchPosition(Socio oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aSocio.length) {
			if (oObjeto.equals(aSocio[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Socio searchObject(Socio oObjeto) {
		Socio oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aSocio.length) {
			if (oObjeto.equals(aSocio[iContador])) {
				oDevolver = aSocio[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Socio oObjeto) {
		int iRes=0;
		boolean bExito = false;
		if (iContSocio < aSocio.length && searchPosition(oObjeto) == -1) {
			aSocio[iContSocio] = oObjeto;
			setiContSocio(iContSocio + 1);
			bExito = true;
		}if(bExito) {
			String sql = "INSERT INTO socio VALUES (" +oObjeto.getsNombre_Usuario()+","+oObjeto.getfMonedero()+
					","+oObjeto.getsContrasenya()+")";
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Socio read(Socio oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Socio oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aSocio[iPosicion] = oObjeto;
			bExito = true;
		}if(bExito) {
			String sql = "UPDATE socio ";
			sql += "SET Monedero=" +oObjeto.getfMonedero()+",Contrasenya="+oObjeto.getsContrasenya();
			sql += "WHERE Nombre_Usuario=" +oObjeto.getsNombre_Usuario();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Socio oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aSocio.length; iCont++) {
				aSocio[iCont - 1] = aSocio[iCont];
			}
			aSocio[aSocio.length - 1] = null;
			setiContSocio(iContSocio - 1);
			bExito = true;
		}if(bExito) {
			String sql = "DELETE FROM socio WHERE Nombre_Usuario =" +oObjeto.getsNombre_Usuario();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public String printAll() {
		String sResultado = "";

		if (iContSocio == 0) {
			sResultado = "No hay Socio registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContSocio; iCont++) {
				sResultado += aSocio[iCont] + "\n";
			}
		}
		return sResultado;
	}
	
}
