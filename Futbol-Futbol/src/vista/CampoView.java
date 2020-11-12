package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Campo;

public class CampoView {

	public void subMenuCampo(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Campo.class.getSimpleName());
			bOperacionExito = gestionarOpcionCampo(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionCampo(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Campo
			bOperacionExito = aniadirCampo(f);
			break;
		case 2: // Modificar Campo
			bOperacionExito = modificarCampo(f);
			break;
		case 3: // Eliminar Campo
			bOperacionExito = eliminarCampo(f);
			break;
		case 4: // Buscar Campo
			Campo oCampo = buscarCampo(f);
			if (oCampo != null) {
				System.out.println(oCampo);
			} else {
				System.out.println("No se han encontrado Campos con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Campos
			System.out.println(mostrarCampos(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirCampo(Futbol f) {
		String sNombre_Campo;
		int iCapacidad = 0;
		boolean errorControl;
		

		sNombre_Campo = LibFrontend.leer("Introduzca el nombre del Campo: ");
	
		
		errorControl = true;
		while (errorControl) {
			try {
				iCapacidad = (int) LibFrontend.valida("Introduzca la capacidad del Campo: ", 1, 40000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aCampo.add(new Campo(sNombre_Campo, iCapacidad));
	}

	private boolean modificarCampo(Futbol f) {
		String sNombre_Campo;
		int iCapacidad = 0;
		boolean bExito = false, errorControl = false;

		sNombre_Campo = LibFrontend.leer("Introduzca el nombre del Campo que desee modificar: ");
		Campo oCampo = f.aCampo.searchObject(new Campo(sNombre_Campo));
		if (oCampo != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					iCapacidad = (int) LibFrontend.valida("Introduzca nueva capacidad del Campo: ", 1, 40000, 1);
					oCampo.setiCapacidad(iCapacidad);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aCampo.update(oCampo);
		}
		return bExito;
	}

	private boolean eliminarCampo(Futbol f) {
		String sNombre_Campo;
		sNombre_Campo = LibFrontend.leer("Introduzca el nombre del Campo que desee eliminar: ");
		return f.aCampo.delete(new Campo(sNombre_Campo));
	}

	private Campo buscarCampo(Futbol f) {
		String sNombre_Campo;
		sNombre_Campo = LibFrontend.leer("Introduzca el nombre del Campo que desee buscar: ");
		return f.aCampo.searchObject(new Campo(sNombre_Campo));
	}

	private String mostrarCampos(Futbol f) {
		return f.aCampo.printAll();
	}
}
