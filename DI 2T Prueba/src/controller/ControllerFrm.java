package controller;

import java.sql.SQLException;

import logic.LogPrincipal;

public class ControllerFrm {
	
	
	public static void establecerConexi�n() throws SQLException {
		
		
		LogPrincipal.establecerConexion();
		
		
		
	}
	

}
