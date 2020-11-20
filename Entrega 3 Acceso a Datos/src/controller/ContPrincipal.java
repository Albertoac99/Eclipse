package controller;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import logic.LogPrincipal;

public class ContPrincipal {

	public static void conexionDB(String dB_HOST, String dB_PORT, String dB_SID, String dB_USER, String dB_PASS) {
		
		LogPrincipal.conexionDB(dB_HOST,dB_PORT,dB_SID,dB_USER,dB_PASS);
		
	}
	
	public static void creacion() throws TransformerConfigurationException, TransformerFactoryConfigurationError {
		
		
		LogPrincipal gestDB= new LogPrincipal();
		
		LogPrincipal.createDbXML(gestDB);
		
	}
	
	

}
