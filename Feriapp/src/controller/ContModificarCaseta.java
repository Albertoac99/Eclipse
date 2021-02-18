package controller;

import javax.swing.JOptionPane;

import logic.LogFeriapp;
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

	public static boolean actualizarCaseta() {
		boolean bExito;
		
		if(comprobaciones()) {
			int aforoMaximo= Integer.parseInt(ModificarCaseta.txtAforoMaximo.getText().toString());
			int aforoActual= Integer.parseInt(ModificarCaseta.txtAforoActual.getText().toString());
			String horario = ModificarCaseta.txtHoraApertura.getText().toString();
			int tipoCaseta= cambioCaseta();
			int numeroCaseta = Integer.parseInt(ModificarCaseta.txtNumeroCaseta.getText().toString());
			
			String url = "https://arandacastroalberto.000webhostapp.com/php/updateCaseta.php?aforoMaximo="+aforoMaximo+"&aforoActual="+aforoActual+"&horario="+horario+"&tipoCaseta="+tipoCaseta+"&numeroCaseta="+numeroCaseta;
			bExito = true;
		try {
			LogFeriapp.peticionHttp(url);
			ContAdminCasetas.casetasPropias();
		} catch (Exception e) {
			LogFeriapp.error(e.getMessage());
		}
		}
		else {
			bExito = false;
			JOptionPane.showMessageDialog(null, "Requisitos:\n	- Rellenar todos los campos\n	- Aforo actual debe ser menor o igual al máximo", "Error al crear caseta", JOptionPane.ERROR_MESSAGE);
		}
		return bExito;
		
	}

	private static int cambioCaseta() {
		int tipoCaseta;
		
		if(ModificarCaseta.chckbxCasetaPrivada.isSelected()) {
			tipoCaseta = 1;
		}
		else {
			tipoCaseta = 0;
		}
		
		return tipoCaseta;
	}

	public static void casetaActualizada() {
		
		JOptionPane.showMessageDialog(null, "Los datos de la caseta han sido actulizados correctamente", "Actualización", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public static boolean borrarCaseta() {
		boolean bBorrado;
		
		if(JOptionPane.showConfirmDialog(null, "¿Desea salir de Feriapp?", "Confirmar Salir", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			int numeroCaseta = 	Integer.parseInt(ModificarCaseta.txtNumeroCaseta.getText().toString());
		
			String url = "https://arandacastroalberto.000webhostapp.com/php/borrarCaseta.php?numeroCaseta="+numeroCaseta;
		
			try {
				LogFeriapp.peticionHttp(url);
			} catch (Exception e) {
				LogFeriapp.error(e.getMessage());
			}
		
			ContAdminCasetas.casetasPropias();	
			
			bBorrado = true;
		}
		else {
			bBorrado = false;
		}
		
			
		return bBorrado;
	}
	
	private static boolean comprobaciones() {
		boolean bExito;
		
		if(camposVacios() || tamañoSuperado()) {
			bExito = false;
		}
		else {
			bExito = true;
		}
		return bExito;
	}

	private static boolean tamañoSuperado() {
		boolean bSuperado;
		
		if(Integer.parseInt(ModificarCaseta.txtAforoMaximo.getText().toString()) < Integer.parseInt(ModificarCaseta.txtAforoActual.getText().toString())) {
			bSuperado = true;
		}
		else {
			bSuperado = false;
		}
		return bSuperado;
	}

	private static boolean camposVacios() {
		boolean bVacios;
		
		if( ModificarCaseta.txtAforoMaximo.getText().toString().equals("") || ModificarCaseta.txtAforoActual.getText().toString().equals("") ||
				ModificarCaseta.txtHoraApertura.getText().toString().equals("")) {
			
			bVacios = true;
		}
		else {
			bVacios = false;
		}
	
		return bVacios;
	}

	
	

}
