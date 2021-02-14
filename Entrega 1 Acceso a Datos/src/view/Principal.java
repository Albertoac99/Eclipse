package view;


import logic.LogPrincipal;

public class Principal {
	
	final static String FILE_NAME_OBJ = "archivos\\datos.dat";
	final static String FILE_NAME_XML = "archivos\\datos.xml";

	public static void main(String[] args) {
		
		//LogPrincipal.escritura(FILE_NAME_OBJ);
		
		LogPrincipal.convert_file_object_to_xml(FILE_NAME_OBJ,FILE_NAME_XML);
		
	}
	

}
