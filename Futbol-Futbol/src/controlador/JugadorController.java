package controlador;

import modelo.Jugador;

public class JugadorController implements InterfaceFutbol<Jugador>{

	private Jugador aJugador[];
	private int iContJugador;
	
	public JugadorController(int numJugadors) {
		aJugador = new Jugador[numJugadors];
		setiContJugador(0);
	}
	
	public Jugador[] getaJugador() {
		return aJugador;
	}
	public void setaJugador(Jugador[] aJugador) {
		this.aJugador = aJugador;
	}
	public int getiContJugador() {
		return iContJugador;
	}
	public void setiContJugador(int iContJugador) {
		this.iContJugador = iContJugador;
	}
	
	
	public int searchPosition(Jugador oObjeto) {
		int iPosicion = -1;
		int iContador = 0;
		while (iPosicion == -1 && iContador < aJugador.length) {
			if (oObjeto.equals(aJugador[iContador])) {
				iPosicion = iContador;
			}
			iContador++;
		}
		return iPosicion;
	}
	
	public Jugador searchObject(Jugador oObjeto) {
		Jugador oDevolver = null;
		int iContador = 0;
		while (oDevolver == null && iContador < aJugador.length) {
			if (oObjeto.equals(aJugador[iContador])) {
				oDevolver = aJugador[iContador];
			}
			iContador++;
		}
		return oDevolver;
	}
	
	public boolean add(Jugador oObjeto) {
		int iRes=0;
		boolean bExito = false;
		if (iContJugador < aJugador.length && searchPosition(oObjeto) == -1) {
			aJugador[iContJugador] = oObjeto;
			setiContJugador(iContJugador + 1);
			bExito = true;
		}if(bExito) {
			String sql = "INSERT INTO jugador VALUES (" +oObjeto.getsApodo() +
					"," +oObjeto.getiPosicion()+ "," +oObjeto.getiDorsal()+ ")";
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	
	public Jugador read(Jugador oObjeto) {
		return searchObject(oObjeto);
	}


	public boolean update(Jugador oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			aJugador[iPosicion] = oObjeto;
			bExito = true;
		}if(bExito) {
			String sql = "UPDATE jugador ";
			sql += "SET Posicion = " +oObjeto.getiPosicion()+","+oObjeto.getiDorsal();
			sql += "WHERE Apodo = " +oObjeto.getsApodo();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}

	
	public boolean delete(Jugador oObjeto) {
		int iRes=0;
		boolean bExito = false;
		int iPosicion = searchPosition(oObjeto);
		if (iPosicion != -1) {
			for (int iCont = iPosicion + 1; iCont < aJugador.length; iCont++) {
				aJugador[iCont - 1] = aJugador[iCont];
			}
			aJugador[aJugador.length - 1] = null;
			setiContJugador(iContJugador - 1);
			bExito = true;
		}if(bExito) {
			String sql = "DELETE FROM jugador WHERE Apodo =" +oObjeto.getsApodo();
			iRes=ConexionDB.executeUpdate(sql);
		}
		return bExito;
	}
	
	public String printAll() {
		String sResultado = "";

		if (iContJugador == 0) {
			sResultado = "No hay Jugador registrados en la aplicacion.";
		} else {
			for (int iCont = 0; iCont < iContJugador; iCont++) {
				sResultado += aJugador[iCont] + "\n";
			}
		}
		return sResultado;
	}
}
