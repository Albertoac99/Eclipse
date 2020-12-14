package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {

	private String host;
    private String port;
    private String user;
    private String password;
    private String pattern;
    private static Connection connectionDb = null;

    public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ConexionDB(String host, String port, String database, String user, String password) {
    pattern = "jdbc:oracle://" + host + ":" + port + "/";
	String url = pattern + database;

	// Registramos el Driver
	try {
	    Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException ex) {
	    System.out.println("Error al registrar el driver de OracleDB: " + ex);
	}

	// Establecemos la conexion
	try {
	    connectionDb = DriverManager.getConnection(url, user, password);
	} catch (Exception sqle) {
	    connectionDb = null;
	}
    }
    
    public static boolean checkConnectionDatabase() {
	boolean bConnected;	
	try {
	    connectionDb.isValid(5000);
	    bConnected = true;
	} catch (Exception e) {
	    bConnected = false;
	}
	return bConnected;
    }

    public static void disconnectDatabase () {
	try {
	    connectionDb.close();
	} catch (Exception e) {
	    connectionDb = null;
	}
    }
    
    public static Connection getConnection() {
	return connectionDb;
    }
    
    public static int executeCount(String sql) {
	Statement stm = null;
	ResultSet rs = null;
	int iCount = 0;
	
	try {
	    stm = ConexionDB.getConnection().createStatement();
	    rs = stm.executeQuery(sql);
	    if(rs.next()) {
		iCount = rs.getInt(1);
	    }	    
	    stm.close();
	    rs.close();
	} catch(SQLException e) {
	    iCount = 0;
	}
	
	return iCount;
    }
    
    public static int executeUpdate(String sql) {
	Statement stm = null;
	int iCount = 0;
	
	try {
	    stm = ConexionDB.getConnection().createStatement();
	    iCount = stm.executeUpdate(sql);
	    stm.close();
	} catch(SQLException e) {
	    iCount = 0;
	}	
	return iCount;
    }
	
}
