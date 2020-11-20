package controller;

import java.util.List;

import logic.LogPrincipal;
import model.Comunidad;

public class ContPrincipal {

	public static void lecturaXML(String FILE_NAME) {
		
		LogPrincipal fch = new LogPrincipal(FILE_NAME);
		
		List<Comunidad> comunidades = fch.getComunidad();
		
		for(Comunidad c : comunidades) {
			System.out.println(c);
		}
		
	}

}
