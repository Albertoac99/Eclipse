package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Convocatoria;
import modelo.Socio;

public class ConvocatoriaView {

	public void subMenuConvocatoria(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Convocatoria.class.getSimpleName());
			bOperacionExito = gestionarOpcionConvocatoria(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionConvocatoria(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Convocatoria
			bOperacionExito = aniadirConvocatoria(f);
			break;
		case 2: // Modificar Convocatoria
			bOperacionExito = modificarConvocatoria(f);
			break;
		case 3: // Eliminar Convocatoria
			bOperacionExito = eliminarConvocatoria(f);
			break;
		case 4: // Buscar Convocatoria
			Convocatoria oConvocatoria = buscarConvocatoria(f);
			if (oConvocatoria != null) {
				System.out.println(oConvocatoria);
			} else {
				System.out.println("No se han encontrado Convocatorias con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Convocatorias
			System.out.println(mostrarConvocatorias(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirConvocatoria(Futbol f) {
		String sOnce;
		int iId_Convocatoria = 0;
		boolean errorControl;
		
		errorControl = true;
		while (errorControl) {
			try {
				iId_Convocatoria = (int) LibFrontend.valida("Introduzca el ID de la Convocatoria: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		sOnce = LibFrontend.leer("Introduzca el Once: ");
	
		
		

		return f.aConvocatoria.add(new Convocatoria(iId_Convocatoria,sOnce));
	}

	private boolean modificarConvocatoria(Futbol f) {
		String sOnce;
		int iId_Convocatoria = 0;
		boolean bExito = false, errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_Convocatoria = (int) LibFrontend.valida("Introduzca el ID de la Convocatoria: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		Convocatoria oConvocatoria = f.aConvocatoria.searchObject(new Convocatoria(iId_Convocatoria));
		if (oConvocatoria != null) {

			
			sOnce = LibFrontend.leer("Introduzca el once: ");
			oConvocatoria.setsOnce(sOnce);
			bExito = f.aConvocatoria.update(oConvocatoria);
		}
		return bExito;
	}

	private boolean eliminarConvocatoria(Futbol f) {
		int iId_Convocatoria = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_Convocatoria = (int) LibFrontend.valida("Introduzca el ID de la Convocatoria: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aConvocatoria.delete(new Convocatoria(iId_Convocatoria));
	}

	private Convocatoria buscarConvocatoria(Futbol f) {
		int iId_Convocatoria = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_Convocatoria = (int) LibFrontend.valida("Introduzca el ID de la Convocatoria: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aConvocatoria.searchObject(new Convocatoria(iId_Convocatoria));
	}

	private String mostrarConvocatorias(Futbol f) {
		return f.aConvocatoria.printAll();
	}
	
}
