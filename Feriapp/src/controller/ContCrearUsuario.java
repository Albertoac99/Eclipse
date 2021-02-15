package controller;

import javax.swing.JOptionPane;

import logic.LogFeriapp;
import view.CrearUsuario;

public class ContCrearUsuario {
	public static String nombreUsuario;

	public static boolean crearUsuario() {
		boolean bExito;
		String usuario = CrearUsuario.txtNuevoUsuario.getText().toString();
		String contrasenia = CrearUsuario.txtContrasenia.getText().toString();
		int tipoUsuario = comprobarTipoUsuario();
		
		if(usuario.equals("") || contrasenia.equals("")) {
			bExito = false;
		}
		else {
			String url = "https://arandacastroalberto.000webhostapp.com/php/getUser.php?usuario="+usuario;
			String respuesta;
			try {
				respuesta = LogFeriapp.peticionHttp(url);
				nombreUsuario = LogFeriapp.JsonToComprobarCuenta(respuesta);
			 }catch (Exception e) {
				
				LogFeriapp.error(e.getMessage());
			}
			if(nombreUsuario==null) {
				
				url = "https://arandacastroalberto.000webhostapp.com/php/insertarUsuario.php?usuario="+usuario+"&contrasenia="+contrasenia+"&tipoUsuario="+tipoUsuario;
				try {
					LogFeriapp.peticionHttp(url);
				} catch (Exception e) {
					
					LogFeriapp.error(e.getMessage());
				}
				bExito = true;
			}
			else {
				bExito = false;
			}
			
		}
		
		return bExito;
	}

	private static int comprobarTipoUsuario() {
		int tipoUsuario;
		if(CrearUsuario.cbxDueño.isSelected()) {
			tipoUsuario = 1;
		}
		else {
			tipoUsuario = 0;
		}
		
		return tipoUsuario;
	}

	public static void errorCrear() {
	
		JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre, por favor introduca otro", "Error al crear usuario", JOptionPane.ERROR_MESSAGE);
		
	}

}
