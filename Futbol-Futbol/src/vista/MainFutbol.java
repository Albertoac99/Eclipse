package vista;

import java.sql.SQLException;

import controlador.ConexionDB;
import controlador.Futbol;
import medac.validaciones.LibFrontend;

public class MainFutbol {

	public static final int MAXCAMPO = 10;
	public static final int MAXCARNET = 10000;
	public static final int MAXCLUB = 10;
	public static final int MAXCONVOCATORIA = 100;
	public static final int MAXENTRADA = 10000;
	public static final int MAXJUGADOR = 220;
	public static final int MAXSOCIO = 10000;
	public static final int MAXVENTAENTRADA = 10000;
	
	public static void main(String[] args) {
		CampoView vistaCampo = new CampoView();
		CarnetView vistaCarnet = new CarnetView();
		ClubView vistaClub = new ClubView();
		ConvocatoriaView vistaConvocatoria = new ConvocatoriaView();
		EntradaView vistaEntrada = new EntradaView();
		JugadorView vistaJugador = new JugadorView();
		SocioView vistaSocio = new SocioView();
		Venta_EntradaView vistaVenta_Entrada = new Venta_EntradaView();
		
		byte bOpcionMenuPrincipal;
		
		Futbol f = new Futbol("FUTBOL",MAXCAMPO,MAXCARNET,MAXCLUB,MAXCONVOCATORIA,MAXENTRADA,MAXJUGADOR,MAXSOCIO,MAXVENTAENTRADA);
		
		if(ConexionDB.checkConnectionDatabase()) {
		
		System.out.println("Bienvenido al panel de administración");
		
		do {
			bOpcionMenuPrincipal = menuPrincipal();
			switch (bOpcionMenuPrincipal) {
			case 1: 
				vistaCampo.subMenuCampo(f);
				break;
			case 2:
				vistaCarnet.subMenuCarnet(f);
				break;
			case 3:
				vistaClub.subMenuClub(f);
				break;
			case 4:
				vistaConvocatoria.subMenuConvocatoria(f);
				break;
			case 5:
				vistaEntrada.subMenuEntrada(f);
				break;
			case 6:
				vistaJugador.subMenuJugador(f);
				break;
			case 7:
				vistaSocio.subMenuSocios(f);
				break;
			case 8:
				vistaVenta_Entrada.subMenuVenta_Entrada(f);
				break;
			
				default: 
					try {
						ConexionDB.getConnection().close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("Hasta la próxima");
			}
			}while(bOpcionMenuPrincipal != 9);
	}else {
		System.out.println("No se ha podido conectar a la base de datos");
	}
	}
	
	
	private static byte menuPrincipal() {
		boolean errorControl = false;
		Byte bOpcion = 0;
		System.out.println("#############################################");
		System.out.println("¿Que desea gestionar?");
		System.out.println("1. Gestionar campos.");
		System.out.println("2. Gestionar carnets.");
		System.out.println("3. Gestionar clubs.");
		System.out.println("4. Gestionar convocatorias.");
		System.out.println("5. Gestionar entradas.");
		System.out.println("6. Gestionar jugadores");
		System.out.println("7. Gestionar socios");
		System.out.println("8. Gestionar ventas de entrada");
		System.out.println("9. Salir");

		
		errorControl = true;
		while (errorControl) {
			try {
				bOpcion = (byte) LibFrontend.valida("Introduce una opcion valida: ", 1, 9, 3);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}
		return bOpcion;
	}

	public static byte subMenu(String sClase) {
		boolean errorControl = false;
		Byte bOpcion = 0;
		System.out.println("¿Que desea hacer?");
		System.out.println("--------------------------");
		System.out.println("1. Añadir " + sClase);
		System.out.println("2. Modificar " + sClase);
		System.out.println("3. Eliminar " + sClase);
		System.out.println("4. Buscar " + sClase);
		System.out.println("5. Mostrar " + sClase);
		System.out.println("6. Volver a menu principal");

		errorControl = true;
		while (errorControl) {
			try {
				bOpcion = (byte) LibFrontend.valida("Introduzca una opcion valida: ", 1, 6, 3);
				errorControl = false;
			} catch (NumberFormatException ex) {
				System.out.println(ex.getMessage());
			} catch (Exception ex) {
				errorControl = false;
				System.out.println("Error generico: " + ex.getMessage());
			}
		}

		return bOpcion;
	}

}
