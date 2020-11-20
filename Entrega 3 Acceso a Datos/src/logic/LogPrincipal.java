package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import dbm.DB_Oracle;

public class LogPrincipal {
	private static Document docXML;

	public static void GestFichero(String nombre) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		dbFactory.setNamespaceAware(true);
		try {

			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();

			DOMImplementation implement = dbBuilder.getDOMImplementation();

			docXML = implement.createDocument(null, nombre, null);

		} catch (ParserConfigurationException e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	public static void saveData(String filename) throws TransformerConfigurationException, TransformerFactoryConfigurationError {
		try {
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			tr.setOutputProperty(OutputKeys.METHOD, "xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apacha.org/xslt}indent-amount", "4");

			try {
				tr.transform(new DOMSource(docXML), new StreamResult(new FileOutputStream(filename)));
			} catch (TransformerException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			System.out.println("Error al guardar" + e.getMessage());
		}

	}

	public static void addElementoXML(Element elemento1, String contenido, String nombre) {

		Element elemento = docXML.createElement(nombre);
		elemento.appendChild(docXML.createTextNode(contenido));
		elemento1.appendChild(elemento);

		System.out.println(nombre + "\n" + contenido);
	}

	public static void createDbXML(LogPrincipal LP) throws TransformerConfigurationException, TransformerFactoryConfigurationError {

		try {
			Connection connection = dbm.DB_Oracle.getConnection();
			
			ResultSet resultado = LP.getData(connection, "SELECT TABLE_NAME FROM USER_TABLES");
			
			
			while (resultado.next()) {
				String tabla = resultado.getString(1);
				GestFichero(tabla);
				
				ResultSet result=LP.getData(connection, "SELECT * FROM "+tabla);
				ResultSetMetaData resultMD= result.getMetaData();
				Element elemento;
				
				while(result.next()) {
					elemento=docXML.createElement(tabla);
					for(int i=1;i<=resultMD.getColumnCount();i++) {
						String Nombre=resultMD.getColumnName(i);
						String Contenido="";
						Contenido=result.getString(i);
						
						addElementoXML(elemento,Contenido,Nombre);
					}
					docXML.getFirstChild().appendChild(elemento);
				}
				saveData("archivos\\"+tabla+".XML");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection conexionDB(String dB_HOST, String dB_PORT, String dB_SID, String dB_USER, String dB_PASS) {
		
		DB_Oracle.DB_HOST = dB_HOST;
		DB_Oracle.DB_PORT = dB_PORT;
		DB_Oracle.DB_SID = dB_SID;
		DB_Oracle.DB_USER = dB_USER;
		DB_Oracle.DB_PASS = dB_PASS;
		
		Connection connection = DB_Oracle.getConnection();
		
		return connection;
	}
	
	public  ResultSet getData(Connection conn,String sql) {
		ResultSet resultado = null;
		try {
			Statement estado= conn.createStatement();
			
			resultado= estado.executeQuery(sql);
		} catch (SQLException e) {
			System.err.println("Error:" +e.getMessage());
		}
		
		
		return resultado;
		
	}
	
	public static void closeconn(Connection conn) {
		dbm.DB_Oracle.closeConnection(conn);
	}

	
	

}
