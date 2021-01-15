package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import dbm.DataBase;
import model.Coche;

public class LogCoches {

	public static List<Coche> getCoches() throws SQLException {
		
		// Obtener los datos de la base de datos
		dbm.DataBase.openConnectionMySQL();
		String query = "SELECT * FROM Coche ORDER BY MARCA, MODELO";
		CachedRowSet crs = dbm.DataBase.ExecuteQuery(query);
		dbm.DataBase.closeConnection();
		
		
		// Creamos al lista de coches
		List<Coche> lstCoches = new ArrayList<Coche>();
		
		while(crs.next()) {
			lstCoches.add(
					new Coche(crs.getInt("ID_COCHE")
							, crs.getString("MARCA")
							, crs.getString("MODELO")
							, crs.getInt("POTENCIA"))
					);
			
		}
		
		
		return null;
	}

	public static Coche getCoche(Integer id) throws SQLException {
		dbm.DataBase.openConnectionMySQL();
		String query = "SELECT * FROM Coche WHERE ID_COCHE = " +id;
		CachedRowSet crs = dbm.DataBase.ExecuteQuery(query);
		dbm.DataBase.closeConnection();
		
		crs.next();
		
		Coche c = new Coche(crs.getInt("ID_COCHE")
				, crs.getString("MARCA")
				, crs.getString("MODELO")
				, crs.getInt("POTENCIA")
		);
		
		
		return c;
	}

	public static void putCoche(Coche c) throws SQLException {
		String strSQL = "UPDATE Coche"
				+ ", MODELO='" +c.getMarca()+ "' "
				+ ", MODELO= '"+c.getModelo()+"' "
				+ ", POTENCIA = '" +c.getPotencia()+ "' "
				+ "WHERE ID_COCHE = " + c.getIdCoche();
		
		
		
		DataBase.openConecctionOracle();
		DataBase.ExecuteQuery(strSQL);
		DataBase.closeConnection();
		
	}
	
	

}
