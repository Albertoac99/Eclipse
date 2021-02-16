package controller;

import java.util.List;

import javax.swing.JOptionPane;

import logic.LogFeriapp;
import model.Cuenta;
import view.Logueo;

public class ContLogueo {
	public static List<Cuenta> lstCuentas;
	public static String rutaPreferencias = "dat\\preferencias.dat";

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
				
				LogFeriapp.error(e.getMessage());
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
		
		JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
		
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

	public static boolean preferencias() {
		boolean bExito;
		
		lstCuentas = LogFeriapp.readDataObject(rutaPreferencias);
		
		if(lstCuentas.isEmpty()) {
			bExito = false;
		}
		else {
			bExito = true;
		}
		return bExito;
	}

	public static void guardarDatos() {
		if (JOptionPane.showConfirmDialog(null, "¿Recordar usuario y contraseña?", "Guardar Datos", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			LogFeriapp.writeDataObject(rutaPreferencias, lstCuentas);
		}
		
	}

}
