package vista;


import controlador.Futbol;
import medac.validaciones.LibFrontend;
import modelo.Socio;


public class SocioView {

	public void subMenuSocios(Futbol f) {
		byte bOpcionSubMenu;
		boolean bOperacionExito;

		do {
			bOpcionSubMenu = MainFutbol.subMenu(Socio.class.getSimpleName());
			bOperacionExito = gestionarOpcionSocio(bOpcionSubMenu, f);

			if (bOpcionSubMenu > 0 && bOpcionSubMenu < 4) {
				if (bOperacionExito) {
					System.out.println("Operacion realizada con exito.");
				} else {
					System.out.println("ERROR: No se ha realizado la operacion.");
				}
			}

		} while (bOpcionSubMenu != 6);
	}

	private boolean gestionarOpcionSocio(byte bOpcion, Futbol f) {
		boolean bOperacionExito = false;
		switch (bOpcion) {
		case 1: // Añadir Socio
			bOperacionExito = aniadirSocio(f);
			break;
		case 2: // Modificar Socio
			bOperacionExito = modificarSocio(f);
			break;
		case 3: // Eliminar Socio
			bOperacionExito = eliminarSocio(f);
			break;
		case 4: // Buscar Socio
			Socio oSocio = buscarSocio(f);
			if (oSocio != null) {
				System.out.println(oSocio);
			} else {
				System.out.println("No se han encontrado Socios con la informacion introducida.");
			}
			break;
		case 5: // Mostrar Socios
			System.out.println(mostrarSocios(f));
			break;
		case 6:
			System.out.println("Volviendo al menu principal...");
			break;
		default:
			System.out.println("Opcion incorrecta.");
		}
		return bOperacionExito;
	}

	private boolean aniadirSocio(Futbol f) {
		String sNombre, sDNI, sApellido, sNombre_Usuario, sContrasenya;
		float fMonedero = 0;
		boolean errorControl;
		

		sNombre = LibFrontend.leer("Introduzca el nombre del Socio: ");
		sDNI = LibFrontend.leer("Introduzca el DNI del Socio: ");
		while(sDNI.length()!=9) {
			sDNI = LibFrontend.leer("Introduzca el DNI del Socio: ");
		}
		sApellido = LibFrontend.leer("Introduzca el apellido del Socio: ");
		sNombre_Usuario = LibFrontend.leer("Introduzca el nombre de usuario del Socio: ");
		sContrasenya = LibFrontend.leer("Introduzca la contraseña del Socio: ");
		
		errorControl = true;
		while (errorControl) {
			try {
				fMonedero = (float) LibFrontend.valida("Introduzca el saldo del Socio: ", 0, 10000, 2);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return f.aSocio.add(new Socio(sNombre, sDNI, sApellido, sNombre_Usuario, fMonedero, sContrasenya));
	}

	private boolean modificarSocio(Futbol f) {
		String sNombre_Usuario;
		float fMonedero;
		boolean bExito = false, errorControl = false;
		
		sNombre_Usuario = LibFrontend.leer("Introduzca el nombre de usuario del Socio que desee modificar: ");
		Socio oSocio = f.aSocio.searchObject(new Socio(sNombre_Usuario));
		if (oSocio != null) {

			
			errorControl = true;
			while (errorControl) {
				try {
					fMonedero = (float) LibFrontend.valida("Introduzca nuevo saldo del Socio: ", 1, 1000, 2);
					oSocio.setfMonedero(fMonedero);
					errorControl = false;
				} catch (NumberFormatException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception ex) {
					errorControl = false;
					System.out.println("Error generico: " + ex.getMessage());
				}
			}
			bExito = f.aSocio.update(oSocio);
		}
		return bExito;
	}

	private boolean eliminarSocio(Futbol f) {
		String sNombre_Usuario;
		sNombre_Usuario = LibFrontend.leer("Introduzca el nombre de usuario del Socio que desee eliminar: ");
		return f.aSocio.delete(new Socio(sNombre_Usuario));
	}

	private Socio buscarSocio(Futbol f) {
		String sNombre_Usuario;
		sNombre_Usuario = LibFrontend.leer("Introduzca el nombre de usuario del Socio que desee buscar: ");
		return f.aSocio.searchObject(new Socio(sNombre_Usuario));
	}

	private String mostrarSocios(Futbol f) {
		return f.aSocio.printAll();
	}
}
