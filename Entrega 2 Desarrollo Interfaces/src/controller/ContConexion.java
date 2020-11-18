package controller;


import logic.ConexionDB;
import logic.LogPrincipal;
import view.Conexion;
import view.Principal;

public class ContConexion {

	public static void conexion() {
		
		if(Conexion.rdbtnNewRadioButton.isSelected()) {
			System.out.println("hola");
			ConexionDB conexion = new ConexionDB(Conexion.textField.getText(),Conexion.textField_1.getText(),Conexion.textField_2.getText(),Conexion.textField_3.getText(),Conexion.textField_4.getText());
		
			String resultado = LogPrincipal.establecerConexion(conexion);
		
			Principal.lblNewLabel.setText(resultado);
		}
		
		else if(Conexion.rdbtnNewRadioButton_1.isSelected()) {
			
			
		}
		
		
		
		
	}
	
	

}
