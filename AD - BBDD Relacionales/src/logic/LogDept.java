package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbm.DB_Oracle;
import model.Dept;

public class LogDept {
	
	public static List<Dept> getDepts(){
		
		List<Dept> lista = new ArrayList<Dept>();
		
		Connection c = DB_Oracle.getConnection();
		
		ResultSet r = DB_Oracle.getData(c, "SELECT * FROM DEPT ORDDER BY DNAME");
		
		try {
			while(r.next()) {
				
				Integer numero = r.getInt("deptno");
				String nombre = r.getString("dname");
				String localidad = r.getString("loc");
				
				lista.add(new Dept(numero,nombre,localidad));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		DB_Oracle.closeConnection(c);
		return lista;
	}
	

}
