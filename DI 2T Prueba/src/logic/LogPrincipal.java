package logic;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbm.ConexionDB;
import view.FrmPintura;

public class LogPrincipal {

	public static void establecerConexion(){

		Connection c = ConexionDB.getConnection();
			
		ResultSet r = ConexionDB.getData(c, "SELECT JOB, COUNT(*) FROM EMP GROUP BY JOB");
		
		try {
			while(r.next()){
				System.out.println("hola");
			ResultSet resultado = ConexionDB.getData(c, "SELECT COUNT(*) FROM EMP WHERE ENAME LIKE '"+r.getString(1) +"'");
			
			
			FrmPintura.data.setValue(r.getString(1), Integer.parseInt(resultado.getString(1)));
			
			}
		} catch (NumberFormatException e) {
			System.out.println("a");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Tonto");
			e.printStackTrace();
		}
		
		ConexionDB.closeConnection(c);
		
	}
	
	

}
