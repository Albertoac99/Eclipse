package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogPrincipal {

	public static CachedRowSet getData(String strQuery) throws SQLException {
		
		//dbm.DataBase.openConnectionMySQL();
		dbm.DataBase.openConecctionOracle();
		CachedRowSet crs = dbm.DataBase.ExecuteQuery(strQuery);
		dbm.DataBase.closeConnection();
		
		
		
		return crs;
	}

}
