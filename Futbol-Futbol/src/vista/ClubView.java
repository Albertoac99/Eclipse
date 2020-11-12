package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Club;

public class ClubView {

	public void subMenuClub(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Club.class.getSimpleName());
			bOperacionExito = gestionarOpcionClub(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionClub(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Club
			bOperacionExito = aniadirClub(f);
			break;
		case 2: // Modificar Club
			bOperacionExito = modificarClub(f);
			break;
		case 3: // Eliminar Club
			bOperacionExito = eliminarClub(f);
			break;
		case 4: // Buscar Club
			Club oClub = buscarClub(f);
			if (oClub != null) {
				System.out.println(oClub);
			} else {
				System.out.println("No se han encontrado Clubs con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Clubs
			System.out.println(mostrarClubs(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirClub(Futbol f) {
		String sNombre_Club;
		int iNumero_Abonados = 0;
		boolean errorControl;
		

		sNombre_Club = LibFrontend.leer("Introduzca el nombre del Club: ");
	
		
		errorControl = true;
		while (errorControl) {
			try {
				iNumero_Abonados = (int) LibFrontend.valida("Introduzca los números de abonados del Club: ", 1, 40000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aClub.add(new Club(sNombre_Club, iNumero_Abonados));
	}

	private boolean modificarClub(Futbol f) {
		String sNombre_Club;
		int iNumero_Abonados = 0;
		boolean bExito = false, errorControl = false;

		sNombre_Club = LibFrontend.leer("Introduzca el nombre del Club que desee modificar: ");
		Club oClub = f.aClub.searchObject(new Club(sNombre_Club));
		if (oClub != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					iNumero_Abonados = (int) LibFrontend.valida("Introduzca nuevo número de abonados del Club: ", 1, 40000, 1);
					oClub.setiNumero_Abonados(iNumero_Abonados);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aClub.update(oClub);
		}
		return bExito;
	}

	private boolean eliminarClub(Futbol f) {
		String sNombre_Club;
		sNombre_Club = LibFrontend.leer("Introduzca el nombre del Club que desee eliminar: ");
		return f.aClub.delete(new Club(sNombre_Club));
	}

	private Club buscarClub(Futbol f) {
		String sNombre_Club;
		sNombre_Club = LibFrontend.leer("Introduzca el nombre del Club que desee buscar: ");
		return f.aClub.searchObject(new Club(sNombre_Club));
	}

	private String mostrarClubs(Futbol f) {
		return f.aClub.printAll();
	}
}
