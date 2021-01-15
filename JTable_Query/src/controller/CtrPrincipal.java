package controller;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class CtrPrincipal {

	public static void clickEjecutar() {
		
		String strQuery = view.FrmPrincipal.txtQuery.getText();
		
		try {
			
			// Obtener los datos de la baso de datos
			
			CachedRowSet resultado = logic.LogPrincipal.getData(strQuery);
			
			// Creamos el modelo de datos a partir del resultado de la consulta

			DefaultTableModel modelo = utils.GUI.generarTabla(resultado);
			
			
			// Actualizamos la tabla (JTable) en la vista
			
			view.FrmPrincipal.tblResult.setModel(modelo);
			
			
			
		}catch (Exception e) {
			System.err.println("Fallo : " + e.getMessage());
			e.getStackTrace();
		}
		
	}

}
