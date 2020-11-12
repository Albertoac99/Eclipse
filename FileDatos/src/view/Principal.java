package view;

import java.util.List;

import controller.GestFchXML;
import model.Entrenador;
import model.Jugador;

public class Principal {

	final static String FILE_NAME = "archivos\\datos.xml";
	
	
	public static void main(String[] args) {
		

		GestFchXML fch = new GestFchXML(FILE_NAME);
		
		List<Jugador> jugadores = fch.getJugadores();
		
		for(Jugador j : jugadores) {
			System.out.println(j);
		}

		System.out.println("\n");
		List<Entrenador> entrenadores = fch.getEntrenadores(FILE_NAME);
		
		for(Entrenador e : entrenadores) {
			System.out.println(e);
		}
		
		fch.addNodeJugador( new Jugador(123,"Miguelito","Perez Diaz", "Alberto",1200));
		
		List<Jugador> jugadores2 = fch.getJugadores();
		
		for(Jugador j : jugadores2) {
			System.out.println(j);
		}
		
		fch.SaveData();
		
	}

}
