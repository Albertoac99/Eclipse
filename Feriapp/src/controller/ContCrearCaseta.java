package controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import logic.LogFeriapp;
import model.Calle;
import model.Caseta;
import view.CrearCaseta;

public class ContCrearCaseta {

	public static void mostrarCalles() {
		List<Calle> calles = new ArrayList<>();
		
		String url = "https://arandacastroalberto.000webhostapp.com/php/getCalles.php";
		String respuesta;
		try {
			respuesta = LogFeriapp.peticionHttp(url);
			calles = LogFeriapp.JsonToCalles(respuesta);
		
		 }catch (Exception e) {
			 LogFeriapp.error(e.getMessage());
		}
		
		for(Calle c : calles) {
			
			CrearCaseta.comboBox.addItem(c.getNombreCalle());
			
		}
		
		
	}

	public static boolean crearCaseta() {
		boolean bExito = false;
		
		if(comprobaciones()) {
			
			int numeroCaseta= Integer.parseInt(CrearCaseta.txtNumeroCaseta.getText().toString());
			String nombreCaseta = CrearCaseta.txtNombreCaseta.getText().toString().replace(" ", "%20");
			String nombreCalle = CrearCaseta.comboBox.getSelectedItem().toString().replace(" ", "%20");
			int aforoMaximo = Integer.parseInt(CrearCaseta.txtAforoMaximo.getText().toString());
			int aforoActual = Integer.parseInt(CrearCaseta.txtAforoActual.getText().toString());
			String horario = CrearCaseta.txtHoraApertura.getText().toString()+"-"+CrearCaseta.txtHoraCierre.getText().toString().replace(" ", "");
			int tipoCaseta = tipoCaseta();
			int idPropietario = ContLogueo.lstCuentas.getIdCuenta();
			try {
			if(comprobarNombre(nombreCaseta)) {
				JOptionPane.showMessageDialog(null, "Ya existe una caseta con ese nombre", "Error al crear caseta", JOptionPane.ERROR_MESSAGE);		
			}
			else {
				if(comprobarNumero(numeroCaseta)) {
					JOptionPane.showMessageDialog(null, "Ya existe una caseta con numero", "Error al crear caseta", JOptionPane.ERROR_MESSAGE);
				}
				else {
			
				creacionCaseta(numeroCaseta, nombreCaseta, nombreCalle, aforoMaximo, aforoActual, horario, tipoCaseta, idPropietario);
				bExito = true;
			}
				}
			} catch (Exception e) {
				LogFeriapp.error(e.getMessage());
			}
		}
		else {
			bExito = false;
			JOptionPane.showMessageDialog(null, "Requisitos:\n	- Rellenar todos los campos\n	- Aforo actual debe ser menor o igual al máximo", "Error al crear caseta", JOptionPane.ERROR_MESSAGE);
		}
		
		return bExito;
	}

	private static void creacionCaseta(int numeroCaseta, String nombreCaseta, String nombreCalle, int aforoMaximo,
			int aforoActual, String horario, int tipoCaseta, int idPropietario) throws Exception {
		String url = "https://arandacastroalberto.000webhostapp.com/php/insertarCaseta.php?numeroCaseta=" + numeroCaseta + "&nombreCaseta="+ nombreCaseta + "&nombreCalle="+ nombreCalle + "&aforoMaximo="+ aforoMaximo + 
			"&aforoActual="+ aforoActual + "&horario="+ horario +"&tipoCaseta="+ tipoCaseta +"&idPropietario="+ idPropietario;

		LogFeriapp.peticionHttp(url);
		ContAdminCasetas.casetasPropias();
		JOptionPane.showMessageDialog(null, "La caseta se ha creado correctamente");
	}

	private static boolean comprobarNumero(int numeroCaseta){
		boolean bExiste;
		String respuesta;
		Caseta casetasNumero;
		
		String urlNumero = "https://arandacastroalberto.000webhostapp.com/php/getCasetaNumero.php?numeroCaseta="+numeroCaseta;
		System.out.println("EEEEEEEEEEEEE");
		try {
			respuesta = LogFeriapp.peticionHttp(urlNumero);
			casetasNumero = LogFeriapp.JsonToCasetas2(respuesta);
		} catch (Exception e) {
			casetasNumero = null;
		}
		
		if(casetasNumero==null) {
			bExiste = false;
		}
		else {
			bExiste = true;
		}
		return bExiste;
	}

	private static boolean comprobarNombre(String nombreCaseta){
		boolean bExiste;
		Caseta casetasNombre;
		String respuesta;
		String urlNombre = "https://arandacastroalberto.000webhostapp.com/php/getCaseta.php?nombreCaseta="+nombreCaseta;
		try {
			respuesta = LogFeriapp.peticionHttp(urlNombre);
			casetasNombre = LogFeriapp.JsonToCasetas2(respuesta);
		} catch (Exception e) {
			casetasNombre=null;
		}
		
	if(casetasNombre==null) {
		bExiste = false;
	}
	else {
		bExiste = true;
	}
		return bExiste;
	}

	private static int tipoCaseta() {
		int tipoCaseta;
		
		if(CrearCaseta.chckbxCasetaPrivada.isSelected()) {
			tipoCaseta= 1;
		}
		else {
			tipoCaseta = 0;
		}
		
		return tipoCaseta;
	}

	private static boolean comprobaciones() {
		boolean bExito;
		
		if(camposVacios() || tamañoSuperado()) {
			bExito = false;
		}
		else {
			bExito = true;
		}
		return bExito;
	}

	private static boolean tamañoSuperado() {
		boolean bSuperado;
		
		if(Integer.parseInt(CrearCaseta.txtAforoMaximo.getText().toString()) < Integer.parseInt(CrearCaseta.txtAforoActual.getText().toString())) {
			bSuperado = true;
		}
		else {
			bSuperado = false;
		}
		return bSuperado;
	}

	private static boolean camposVacios() {
		boolean bVacios;
		
		if(CrearCaseta.txtNombreCaseta.getText().toString().equals("") || CrearCaseta.txtNumeroCaseta.getText().toString().equals("") || CrearCaseta.txtAforoMaximo.getText().toString().equals("") ||
				CrearCaseta.txtAforoActual.getText().toString().equals("") || CrearCaseta.txtHoraApertura.getText().toString().equals("") || CrearCaseta.txtHoraCierre.getText().toString().equals("")) {
			
			bVacios = true;
		}
		else {
			bVacios = false;
		}
	
		return bVacios;
	}
	
	public static void caracteres(KeyEvent e) {
		
		boolean letra = LogFeriapp.caracteres(e);
		
		if(letra) {
			e.setKeyChar((char) e.VK_DELETE);
		}
		
	}

}
