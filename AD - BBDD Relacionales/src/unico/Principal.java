package unico;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		
		String DB_HOST = "localhost";
		String DB_PORT = "1521";
		String DB_SID = "XE";
		

		String DB_URL = "jdbc:oracle:thin:@" + DB_HOST + ":" + DB_PORT + ":" + DB_SID;
		String DB_URL_MYSQL = "jdbc:mysql://" + DB_HOST + "/"+ DB_SID;
		String DB_USER = "System";
		String DB_PASS = "Medac2020";
		
		
		try {
			Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			
			Statement ordenSQL = conn.createStatement();
			
			String sql = "SELECT * FROM DEP";
			
			ResultSet resultado = ordenSQL.executeQuery(sql);
			
			ResultSetMetaData info = resultado.getMetaData();
			
			System.out.println("Columnas: " +info.getColumnCount());
			
			for(int col=1;col<info.getColumnCount();col++) {
				System.out.println(info.getColumnName(col));
			}
			
			/*
			while(resultado.next()) {

			Integer numero = resultado.getInt("deptno");
			String nombre = resultado.getString("dname");
			String localidad = resultado.getString("loc");
			
			System.out.println("El departamento " +numero+ " se llama " +nombre+ " y esta en " +localidad);
			}
			*/
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
