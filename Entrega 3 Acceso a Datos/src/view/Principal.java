package view;

import java.util.List;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import controller.ContPrincipal;
import validaciones.ValidaLibrary;

public class Principal {

	public static String FILE_NAME_XML = "archivos\\datos.xml";
	public static List<String> lista;
	public static void main(String[] args) throws TransformerConfigurationException, TransformerFactoryConfigurationError {
		
		String DB_HOST = ValidaLibrary.leer("Introduzca el host: ");
		String DB_PORT = ValidaLibrary.leer("Introduzca el port: ");
		String DB_SID = ValidaLibrary.leer("Introduzca el SID: ");
		String DB_USER = ValidaLibrary.leer("Introduzca el usuario: ");
		String DB_PASS = ValidaLibrary.leer("Introduzca la contraseña: ");
		
		ContPrincipal.conexionDB(DB_HOST,DB_PORT,DB_SID,DB_USER,DB_PASS);
		ContPrincipal.creacion();

	}

}
