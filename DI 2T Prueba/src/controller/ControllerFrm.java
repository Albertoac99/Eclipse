package controller;

import java.sql.SQLException;

import logic.LogPrincipal;

public class ControllerFrm {
	
	
	public static void establecerConexión() throws SQLException {
		
		
		LogPrincipal.establecerConexion();
		
		
		
	}
	

}
