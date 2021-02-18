package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import logic.LogFeriapp;
import model.Caseta;
import utils.GUI;
import view.AdminCasetas;

public class ContAdminCasetas {

	public static void casetasPropias() {
		
		int idCuenta = ContLogueo.lstCuentas.getIdCuenta();
		String url = "https://arandacastroalberto.000webhostapp.com/php/getCasetaId.php?idPropietario="+idCuenta;
		String resultado;
		List<Caseta> lstCasetas;
		
		try {
			
			resultado = LogFeriapp.peticionHttp(url);
			
			lstCasetas = LogFeriapp.JsonToCasetas(resultado);
			
			DefaultTableModel modelo = GUI.generarTabla(lstCasetas);
			AdminCasetas.tblCasetasPropias.setModel(modelo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
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

}
