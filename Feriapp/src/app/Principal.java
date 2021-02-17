package app;

import controller.ContLogueo;
import view.ListaCasetas;
import view.Logueo;

public class Principal {

	public static void main(String[] args) {
		if(ContLogueo.preferencias()) {
			ListaCasetas casetas = new ListaCasetas();
			casetas.setVisible(true);
		}
		else {
			Logueo logueo = new Logueo();
			logueo.setVisible(true);
		}
	}

}
