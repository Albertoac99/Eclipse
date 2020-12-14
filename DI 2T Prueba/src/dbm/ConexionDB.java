package dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private static String DB_HOST = "localhost";
	private static String DB_PORT = "1521";
	private static String DB_SID = "MEDAC2020";
	
	
	private static String DB_USER = "Medac";
	private static String DB_PASS = "Medac2020";
	
	
	
	public static Connection getConnection() {
		
		String DB_URL = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + ":" + DB_SID;
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer conexión");
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexión");
			e.printStackTrace();
		}
	}
	
	public static ResultSet getData (Connection conn, String sql) {
		
		ResultSet resultado = null;
		
		Statement ordenSQL;
		try {
			ordenSQL = conn.createStatement();
			resultado = ordenSQL.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("No se ha podido ejecutar la orden : " +sql);
			e.printStackTrace();
		}

	return resultado;
	}
	
	
}
