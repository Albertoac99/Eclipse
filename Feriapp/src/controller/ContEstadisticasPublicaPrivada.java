package controller;

import model.Caseta;
import view.EstadisticasPublicaPrivada;

public class ContEstadisticasPublicaPrivada {

	public static void crearGrafica() {
		
	int numeroPublicas;
	int numeroPrivadas;
		
	numeroPublicas = numeroPublicas();
	numeroPrivadas = numeroPrivadas();
	
	EstadisticasPublicaPrivada.data.setValue("Públicas", numeroPublicas);
	EstadisticasPublicaPrivada.data.setValue("Privadas", numeroPrivadas);
		
	}

	private static int numeroPrivadas() {
		int numeroPrivadas=0;
		
		for(Caseta c : ContListaCasetas.casetas) {
			if(c.getTipoCaseta()==1) {
				numeroPrivadas++;
			}
		}
		return numeroPrivadas;
	}

	private static int numeroPublicas() {
		int numeroPublicas=0;
		
		for(Caseta c : ContListaCasetas.casetas) {
			if(c.getTipoCaseta()==0) {
				numeroPublicas++;
			}
		}
		return numeroPublicas;
	}

}
