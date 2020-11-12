package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Jugador;

public class JugadorView {

	public void subMenuJugador(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Jugador.class.getSimpleName());
			bOperacionExito = gestionarOpcionJugador(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionJugador(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Jugador
			bOperacionExito = aniadirJugador(f);
			break;
		case 2: // Modificar Jugador
			bOperacionExito = modificarJugador(f);
			break;
		case 3: // Eliminar Jugador
			bOperacionExito = eliminarJugador(f);
			break;
		case 4: // Buscar Jugador
			Jugador oJugador = buscarJugador(f);
			if (oJugador != null) {
				System.out.println(oJugador);
			} else {
				System.out.println("No se han encontrado Jugadors con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Jugadors
			System.out.println(mostrarJugadors(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirJugador(Futbol f) {
		String sNombre, sDNI, sApellido, sApodo;
		int iPosicion = 0, iDorsal = 0;
		boolean errorControl;
		

		sNombre = LibFrontend.leer("Introduzca el nombre del Jugador: ");
		sDNI = LibFrontend.leer("Introduzca el DNI del Jugador: ");
		while(sDNI.length()!=9) {
			sDNI = LibFrontend.leer("Introduzca el DNI del Jugador: ");	
		}
		sApellido = LibFrontend.leer("Introduzca el apellido del Jugador: ");
		sApodo = LibFrontend.leer("Introduzca el Apodo del Jugador: ");
		
		errorControl = true;
		while (errorControl) {
			try {
				iPosicion = (int) LibFrontend.valida("Introduzca la posicion del Jugador(1-Portero,2-Defensa,3-Mediocentro,4-Delantero): ", 1, 4, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		
		errorControl = true;
		while (errorControl) {
			try {
				iDorsal = (int) LibFrontend.valida("Introduzca el dorsal del Jugador: ", 1, 99, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aJugador.add(new Jugador(sNombre, sDNI, sApellido, sApodo, iPosicion, iDorsal));
	}

	private boolean modificarJugador(Futbol f) {
		String sApodo;
		int iDorsal = 0;
		boolean bExito = false, errorControl = false;

		sApodo = LibFrontend.leer("Introduzca el apodo de usuario del Jugador que desee modificar: ");
		Jugador oJugador = f.aJugador.searchObject(new Jugador(sApodo));
		if (oJugador != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					iDorsal = (int) LibFrontend.valida("Introduzca nuevo dorsal del Jugador: ", 1, 99, 1);
					oJugador.setiDorsal(iDorsal);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aJugador.update(oJugador);
		}
		return bExito;
	}

	private boolean eliminarJugador(Futbol f) {
		String sApodo;
		sApodo = LibFrontend.leer("Introduzca el apodo del Jugador que desee eliminar: ");
		return f.aJugador.delete(new Jugador(sApodo));
	}

	private Jugador buscarJugador(Futbol f) {
		String sApodo;
		sApodo = LibFrontend.leer("Introduzca el apodo del Jugador que desee buscar: ");
		return f.aJugador.searchObject(new Jugador(sApodo));
	}

	private String mostrarJugadors(Futbol f) {
		return f.aJugador.printAll();
	}
}
