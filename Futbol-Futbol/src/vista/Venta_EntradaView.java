package vista;

import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Socio;
import modelo.Venta_Entrada;

public class Venta_EntradaView {

	public void subMenuVenta_Entrada(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Venta_Entrada.class.getSimpleName());
			bOperacionExito = gestionarOpcionVenta_Entrada(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 7);
	}

	private boolean gestionarOpcionVenta_Entrada(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Venta_Entrada
			bOperacionExito = aniadirVenta_Entrada(f);
			break;
		case 2: // Modificar Venta_Entrada
			bOperacionExito = modificarVenta_Entrada(f);
			break;
		case 3: // Eliminar Venta_Entrada
			bOperacionExito = eliminarVenta_Entrada(f);
			break;
		case 4: // Buscar Venta_Entrada
			Venta_Entrada oVenta_Entrada = buscarVenta_Entrada(f);
			if (oVenta_Entrada != null) {
				System.out.println(oVenta_Entrada);
			} else {
				System.out.println("No se han encontrado Venta_Entradas con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Venta_Entradas
			System.out.println(mostrarVenta_Entradas(f));
			break;
		case 6: //Venta Entrada
			Socio oSoci = new Socio();
			System.out.println(Venta(oSoci));
		case 7:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirVenta_Entrada(Futbol f) {
		int iId_VentaEntrada = 0, iTipo_Venta=0;
		boolean errorControl;
	
		
		errorControl = true;
		while (errorControl) {
			try {
				iId_VentaEntrada = (int) LibFrontend.valida("Introduzca el Id de Venta_Entrada: ", 1, 10000, 1);
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
				iTipo_Venta = (int) LibFrontend.valida("Introduzca el tipo de venta de Venta_Entrada(1-Normal, 2-Expres): ", 1, 2, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aVentaEntrada.add(new Venta_Entrada(iId_VentaEntrada, iTipo_Venta));
	}

	private boolean modificarVenta_Entrada(Futbol f) {
		int iId_VentaEntrada = 0, iTipo_Venta;
		boolean bExito = false, errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_VentaEntrada = (int) LibFrontend.valida("Introduzca el Id de Venta_Entrada: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		Venta_Entrada oVenta_Entrada = f.aVentaEntrada.searchObject(new Venta_Entrada(iId_VentaEntrada));
		if (oVenta_Entrada != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					iTipo_Venta = (int) LibFrontend.valida("Introduzca el tipo de venta de Venta_Entrada: ", 1, 2, 1);
					oVenta_Entrada.setiTipo_Venta(iTipo_Venta);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aVentaEntrada.update(oVenta_Entrada);
		}
		return bExito;
	}

	private boolean eliminarVenta_Entrada(Futbol f) {
		int iId_VentaEntrada = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_VentaEntrada = (int) LibFrontend.valida("Introduzca el Id de Venta_Entrada: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aVentaEntrada.delete(new Venta_Entrada(iId_VentaEntrada));
	}

	private Venta_Entrada buscarVenta_Entrada(Futbol f) {
		int iId_VentaEntrada = 0;
		boolean errorControl = false;

		errorControl = true;
		while (errorControl) {
			try {
				iId_VentaEntrada = (int) LibFrontend.valida("Introduzca el Id de Venta_Entrada: ", 1, 10000, 1);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return f.aVentaEntrada.searchObject(new Venta_Entrada(iId_VentaEntrada));
	}

	private String mostrarVenta_Entradas(Futbol f) {
		return f.aVentaEntrada.printAll();
	}
	
	public String Venta(Socio oSoci) {
		String sResultado ="",Contrasenya;
		Contrasenya=LibFrontend.leer("Para realizar una venta debe confirmar su contraseña");
		if(oSoci.getsContrasenya().equals(Contrasenya)) {
			oSoci.setfMonedero(oSoci.getfMonedero()+50);
			sResultado+= "Se le han ingresado en su cuenta 50€ por la entrada";
		}
		else {
			sResultado += "Contraseña incorrecta. Transferencia fallida.";
		}
		return sResultado;
	}
}
