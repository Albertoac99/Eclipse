package view;

import controller.ContPrincipal;

public class Principal {

	private static String FILE_NAME = "archivos\\temperaturas.xml";
	
	public static void main(String[] args) {
		
		ContPrincipal.lecturaXML(FILE_NAME);

	}

}
