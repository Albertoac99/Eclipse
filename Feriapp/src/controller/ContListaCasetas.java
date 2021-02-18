package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import logic.LogFeriapp;
import model.Caseta;
import model.Cuenta;
import utils.GUI;
import view.ListaCasetas;

public class ContListaCasetas {
	
	public static List<Caseta> casetas;
	
	public static void generarTabla(String url) {
		
	String respuesta;
	try {
		respuesta = LogFeriapp.peticionHttp(url);
		casetas = LogFeriapp.JsonToCasetas(respuesta);
		DefaultTableModel modelo = GUI.generarTabla(casetas);
		ListaCasetas.table.setModel(modelo);
		
	 }catch (Exception e) {	
		LogFeriapp.error(e.getMessage());
	}
	}

	public static boolean salir() {
		boolean bSalir;
		
		if(LogFeriapp.salir()) {
			bSalir = true;
		}
		else {
			bSalir = false;
		}
		
		return bSalir;
	}

	public static void permisos() {
		
		if(ContLogueo.lstCuentas.getTipoUsuario()==1) {
			ListaCasetas.mntmAdministracin.setEnabled(true);
		}
		else {
			ListaCasetas.mntmAdministracin.setEnabled(false);
		}
		
		
		
	}

	public static void desconexion() {
		
		List<Cuenta> cuentas = new ArrayList<>();
		cuentas.add(new Cuenta(99,"","",3));
		
		LogFeriapp.writeDataObject(ContLogueo.rutaPreferencias, cuentas);
		
	}
	

}
