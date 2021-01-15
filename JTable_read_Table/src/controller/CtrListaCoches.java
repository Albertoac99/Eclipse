package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import logic.LogCoches;
import model.Coche;
import utils.GUI;
import view.FrmDetalleCoches;
import view.FrmListaCoches;

public class CtrListaCoches {

	public static void tableRowSelected() {
		
		new FrmDetalleCoches();
		
		
	}

	public static void loadData() {
	
		List<Coche> resultado;
		try {
			resultado = LogCoches.getCoches();
			DefaultTableModel modelo = GUI.generarTableCoches(resultado);
		FrmListaCoches.tblResult.setModel(modelo);
		// Ocultar la columna 0 que contiene la pk
		FrmListaCoches.tblResult.getColumnModel().getColumn(0).setMinWidth(0);
		FrmListaCoches.tblResult.getColumnModel().getColumn(0).setMaxWidth(0);
		FrmListaCoches.tblResult.getColumnModel().getColumn(0).setWidth(0);
		} catch (SQLException e) {
			System.err.println("Error: " +e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
