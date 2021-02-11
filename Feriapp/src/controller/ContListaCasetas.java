package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import logic.LogFeriapp;
import model.Caseta;
import utils.GUI;
import view.ListaCasetas;

public class ContListaCasetas {
	
	private static List<Caseta> casetas;
	
	public static void generarTabla() {
		
		
	String url = "https://arandacastroalberto.000webhostapp.com/php/getCasetas.php";
	String respuesta;
	try {
		respuesta = LogFeriapp.peticionHttp(url);
		casetas = LogFeriapp.JsonToCasetas(respuesta);
		DefaultTableModel modelo = GUI.generarTabla(casetas);
		ListaCasetas.table.setModel(modelo);
		
	 }catch (Exception e) {	
		e.printStackTrace();
	}
	}
	
	

}
