package controller;

import view.Logueo;

public class ContLogueo {

	public static boolean iniciarSesion() {
		boolean bExito;
		
		if(Logueo.txtUsuario.getText().toString().equals("") || Logueo.txtContrasenia.getText().toString().equals("")) {
			bExito = false;
		}
		else {
			bExito = true;
		}
		
		return bExito;
	}

}
