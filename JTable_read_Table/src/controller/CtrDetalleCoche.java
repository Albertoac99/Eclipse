package controller;

import logic.LogCoches;
import model.Coche;
import view.FrmDetalleCoches;
import view.FrmListaCoches;

public class CtrDetalleCoche {

	private static Integer id;
	
	public static void loadData() {
		
		id = Integer.parseInt(FrmListaCoches.tblResult.getValueAt(FrmListaCoches.tblResult.getSelectedRow(), 0).toString());
		
		try {
			
			Coche c = (Coche) LogCoches.getCoche(id);
			FrmDetalleCoches.jtxtMarca.setText(c.getMarca());
			FrmDetalleCoches.jtxtModelo.setText(c.getModelo());
			FrmDetalleCoches.jtxtPotencia.setText(""+c.getPotencia());
			
			
		}catch(Exception e) {
			System.err.println("Error: "+ e.getMessage());
			e.getStackTrace();
		}
		
		
	}
	
	public static void saveData() {
		
		try {
		
			String strMarca = FrmDetalleCoches.jtxtMarca.getText().toString();
			String strModelo = FrmDetalleCoches.jtxtModelo.getText().toString();
			Integer intPotencia = Integer.parseInt(FrmDetalleCoches.jtxtPotencia.getText().toString());
			
			Coche c = new Coche ( id, strMarca, strModelo, intPotencia);
			
			LogCoches.putCoche(c);
			
		}catch(Exception e) {
			System.err.println("Error: " +e.getMessage());
		}
		
	}
	
}
