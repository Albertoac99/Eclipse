package dbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Oracle {

	private static String DB_HOST = "localhost";
	private static String DB_PORT = "1521";
	private static String DB_SID = "MEDAC2020";
	
	
	private static String DB_USER = "Medac";
	private static String DB_PASS = "Medac2020";
	

	public static Connection getConnection() {

		String DB_URL = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + ":" + DB_SID;

		// String DB_URL_MYSQL= "jdbc:mysql://"+DB_HOST + "/"+DB_SID;

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			System.err.println("No se ha podidoc establecer la conexion: " + e.getMessage());
		}
		return conn;
	}

	public static void closeConection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("No se ha podido cerrar la conexion: " + e.getMessage());
		}
	}
	
	public static ResultSet getData(Connection conn, String sql) {
		
		ResultSet resultado = null;
		
		try {
			Statement ordenSQL = conn.createStatement();
			resultado = ordenSQL.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la orden: "+e.getMessage());
		}
		return resultado;
	}
	
	public static void executeSQL(Connection conn, String sql) {
		Statement ordenSQL;
		try {
			ordenSQL = conn.createStatement();
			ordenSQL.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("No se ha podido ejecutar la orden: "+e.getMessage());
		}
	}

}
