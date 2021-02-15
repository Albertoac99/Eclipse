package controller;

import view.AdminCasetas;
import view.ModificarCaseta;

public class ContModificarCaseta {

	public static void insertarDatos() {
		
		ModificarCaseta.txtNombreCaseta.setText(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),1).toString());
		ModificarCaseta.txtNumeroCaseta.setText(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),0).toString());
		ModificarCaseta.txtNombreCalle.setText(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),2).toString());
		ModificarCaseta.txtAforoActual.setText(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),4).toString());
		ModificarCaseta.txtAforoMaximo.setText(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),3).toString());
		ModificarCaseta.txtHoraApertura.setText(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),5).toString());
		if(tipoCaseta()) {
			ModificarCaseta.chckbxCasetaPrivada.setSelected(true);
		}
		
	}

	private static boolean tipoCaseta() {
		boolean bPrivada;
		
		if(AdminCasetas.tblCasetasPropias.getValueAt(AdminCasetas.tblCasetasPropias.getSelectedRow(),6).toString() == "Privada") {
			bPrivada = true;
		}
		else {
			bPrivada = false;
		}
		return bPrivada;
	}

	
	

}
