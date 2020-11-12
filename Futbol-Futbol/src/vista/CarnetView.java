package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Carnet;

public class CarnetView {

	public void subMenuCarnet(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Carnet.class.getSimpleName());
			bOperacionExito = gestionarOpcionCarnet(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionCarnet(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Carnet
			bOperacionExito = aniadirCarnet(f);
			break;
		case 2: // Modificar Carnet
			bOperacionExito = modificarCarnet(f);
			break;
		case 3: // Eliminar Carnet
			bOperacionExito = eliminarCarnet(f);
			break;
		case 4: // Buscar Carnet
			Carnet oCarnet = buscarCarnet(f);
			if (oCarnet != null) {
				System.out.println(oCarnet);
			} else {
				System.out.println("No se han encontrado Carnets con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Carnets
			System.out.println(mostrarCarnets(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirCarnet(Futbol f) {
		int iNumero_Abonado = 0, iTemporada=0;
		boolean errorControl;
	
		
		errorControl = true;
		while (errorControl) {
			try {
				iNumero_Abonado = (int) LibFrontend.valida("Introduzca el número de abonado del Carnet: ", 1, 40000, 1);
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
				iTemporada = (int) LibFrontend.valida("Introduzca la temporada del Carnet: ", 2015, 2040, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aCarnet.add(new Carnet(iNumero_Abonado, iTemporada));
	}

	private boolean modificarCarnet(Futbol f) {
		int iNumero_Abonado = 0, iTemporada;
		boolean bExito = false, errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iNumero_Abonado = (int) LibFrontend.valida("Introduzca el numero de abonado del Carnet: ", 1, 40000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		Carnet oCarnet = f.aCarnet.searchObject(new Carnet(iNumero_Abonado));
		if (oCarnet != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					iTemporada = (int) LibFrontend.valida("Introduzca nueva temporada del Carnet: ", 1, 99, 1);
					oCarnet.setiTemporada(iTemporada);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aCarnet.update(oCarnet);
		}
		return bExito;
	}

	private boolean eliminarCarnet(Futbol f) {
		int iNumero_Abonado = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iNumero_Abonado = (int) LibFrontend.valida("Introduzca el numero de abonado del Carnet: ", 1, 40000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aCarnet.delete(new Carnet(iNumero_Abonado));
	}

	private Carnet buscarCarnet(Futbol f) {
		int iNumero_Abonado = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iNumero_Abonado = (int) LibFrontend.valida("Introduzca el numero de abonado del Carnet: ", 1, 40000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aCarnet.searchObject(new Carnet(iNumero_Abonado));
	}

	private String mostrarCarnets(Futbol f) {
		return f.aCarnet.printAll();
	}
}
