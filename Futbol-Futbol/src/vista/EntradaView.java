package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Entrada;

public class EntradaView {

	public void subMenuEntrada(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Entrada.class.getSimpleName());
			bOperacionExito = gestionarOpcionEntrada(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionEntrada(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Entrada
			bOperacionExito = aniadirEntrada(f);
			break;
		case 2: // Modificar Entrada
			bOperacionExito = modificarEntrada(f);
			break;
		case 3: // Eliminar Entrada
			bOperacionExito = eliminarEntrada(f);
			break;
		case 4: // Buscar Entrada
			Entrada oEntrada = buscarEntrada(f);
			if (oEntrada != null) {
				System.out.println(oEntrada);
			} else {
				System.out.println("No se han encontrado Entradas con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Entradas
			System.out.println(mostrarEntradas(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirEntrada(Futbol f) {
		int iId_Entrada = 0, iPuerta=0, iAsiento=0, iFila=0;
		boolean errorControl;
	
		
		errorControl = true;
		while (errorControl) {
			try {
				iId_Entrada = (int) LibFrontend.valida("Introduzca el Id de la Entrada: ", 1, 10000, 1);
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
				iPuerta = (int) LibFrontend.valida("Introduzca la puerta de la Entrada: ", 1, 20, 1);
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
				iAsiento = (int) LibFrontend.valida("Introduzca el asiento de la Entrada: ", 1, 100, 1);
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
				iFila = (int) LibFrontend.valida("Introduzca la fila de la Entrada: ", 1, 50, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aEntrada.add(new Entrada(iId_Entrada, iPuerta, iAsiento, iFila));
	}

	private boolean modificarEntrada(Futbol f) {
		int iId_Entrada = 0, iPuerta=0, iAsiento=0, iFila=0;
		boolean bExito = false, errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_Entrada = (int) LibFrontend.valida("Introduzca el ID de la Entrada: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		Entrada oEntrada = f.aEntrada.searchObject(new Entrada(iId_Entrada));
		if (oEntrada != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					iPuerta = (int) LibFrontend.valida("Introduzca la puerta de la Entrada: ", 1, 20, 1);
					oEntrada.setiPuerta(iPuerta);
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
					iAsiento = (int) LibFrontend.valida("Introduzca el asiento de la Entrada: ", 1, 100, 1);
					oEntrada.setiAsiento(iAsiento);
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
					iFila = (int) LibFrontend.valida("Introduzca la fila de la Entrada: ", 1, 50, 1);
					oEntrada.setiFila(iFila);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aEntrada.update(oEntrada);
		}
		return bExito;
	}

	private boolean eliminarEntrada(Futbol f) {
		int iId_Entrada = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_Entrada = (int) LibFrontend.valida("Introduzca el ID de la Entrada: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aEntrada.delete(new Entrada(iId_Entrada));
	}

	private Entrada buscarEntrada(Futbol f) {
		int iId_Entrada = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_Entrada = (int) LibFrontend.valida("Introduzca el ID de la Entrada: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aEntrada.searchObject(new Entrada(iId_Entrada));
	}

	private String mostrarEntradas(Futbol f) {
		return f.aEntrada.printAll();
	}
}
