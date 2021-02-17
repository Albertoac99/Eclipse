package controller;

import model.Caseta;
import view.EstadisticasAforo;

public class ContEstadisticasAforo {

	public static void crearGrafica() {
		
		for(Caseta c : ContListaCasetas.casetas) {
			
			EstadisticasAforo.data.addValue(c.getAforoActual(), c.getNombreCaseta(), c.getNombreCaseta());
		}
		
	}

}
