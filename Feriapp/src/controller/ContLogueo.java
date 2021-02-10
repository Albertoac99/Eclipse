package controller;

import java.util.List;

import javax.swing.JOptionPane;

import logic.LogFeriapp;
import model.Cuenta;
import view.Logueo;

public class ContLogueo {
	private static List<Cuenta> lstCuentas;

	public static boolean iniciarSesion() {
		boolean bExito;
		String usuario = Logueo.txtUsuario.getText().toString();
		String contrasenia = Logueo.txtContrasenia.getText().toString();
		
		if(usuario.equals("") || contrasenia.equals("")) {
			bExito = false;
		}
		else {
			String url = "https://arandacastroalberto.000webhostapp.com/php/getUserPassword.php?usuario="+usuario+"&contrasenia="+contrasenia;
			String respuesta;
			try {
				respuesta = LogFeriapp.peticionHttp(url);
				lstCuentas = LogFeriapp.JsonToCuentas(respuesta);
			
			 }catch (Exception e) {
				
				e.printStackTrace();
			}
			if(lstCuentas.isEmpty()) {
				bExito = false;
			}
			else {
				bExito = true;
			}
			
		}
		
		return bExito;
	}

	public static void errorSesion() {
		
		LogFeriapp.errorIniciar();
		
	}

}
