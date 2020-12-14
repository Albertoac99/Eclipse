package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dbm.DB_Oracle;

public class LogicPrincipal {

	private static Connection conn;

	public static Map<String, Integer> pedirDatosDept() throws SQLException {

		conn = DB_Oracle.getConnection();

		Map<String, Integer> mapa = new HashMap<String, Integer>();

		ResultSet r = DB_Oracle.getData(conn, "SELECT DNAME FROM DEPT");

		while (r.next()) {

			ResultSet rSet = DB_Oracle.getData(conn,
					"SELECT COUNT(*) FROM EMP WHERE DEPTNO=( SELECT DEPTNO FROM DEPT WHERE DNAME = '" + r.getString(1)
							+ "')");

			while (rSet.next()) {

				int iDato = Integer.parseInt(rSet.getString(1));

				mapa.put(r.getString(1), iDato);
			}

		}
		return mapa;
	}

	public static Map<String, Integer> pedirDatosJob() throws SQLException {

		conn = DB_Oracle.getConnection();

		Map<String, Integer> mapa = new HashMap<String, Integer>();

		ResultSet r = DB_Oracle.getData(conn, "SELECT JOB FROM EMP");

		while (r.next()) {

			ResultSet rSet = DB_Oracle.getData(conn, "SELECT COUNT(*) FROM EMP WHERE JOB='" + r.getString(1) + "'");

			while (rSet.next()) {

				int iDato = Integer.parseInt(rSet.getString(1));

				mapa.put(r.getString(1), iDato);
			}

		}
		return mapa;
	}

	public static Map<String, ArrayList<Integer>> pedirSalario() throws SQLException {

		conn = DB_Oracle.getConnection();

		Map<String, ArrayList<Integer>> mapa = new HashMap<String, ArrayList<Integer>>();

		ArrayList<Integer> lista = new ArrayList<Integer>();

		ResultSet r = DB_Oracle.getData(conn,"SELECT MAX (SAL),MIN(SAL),DNAME FROM EMP,DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO GROUP BY DNAME");

		while (r.next()) {

			lista.add(Integer.parseInt(r.getString(1)));
			lista.add(Integer.parseInt(r.getString(2)));

			mapa.put(r.getString(3), lista);

		}

		return mapa;
	}
}
