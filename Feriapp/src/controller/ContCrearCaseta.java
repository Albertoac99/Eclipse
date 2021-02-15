package controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import logic.LogFeriapp;
import model.Calle;
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

	public static void crearCaseta() {
		
		if(comprobaciones()) {
			
			int numeroCaseta= Integer.parseInt(CrearCaseta.txtNumeroCaseta.getText().toString());
			String nombreCaseta = CrearCaseta.txtNombreCaseta.getText().toString().replace(" ", "%20");
			String nombreCalle = CrearCaseta.comboBox.getSelectedItem().toString().replace(" ", "%20");
			int aforoMaximo = Integer.parseInt(CrearCaseta.txtAforoMaximo.getText().toString());
			int aforoActual = Integer.parseInt(CrearCaseta.txtAforoActual.getText().toString());
			String horario = CrearCaseta.txtHoraApertura.getText().toString()+"-"+CrearCaseta.txtHoraCierre.getText().toString().replace(" ", "");
			int tipoCaseta = tipoCaseta();
			int idPropietario = ContLogueo.lstCuentas.get(0).getIdCuenta();
			
			String url = "https://arandacastroalberto.000webhostapp.com/php/insertarCaseta.php?numeroCaseta=" + numeroCaseta + "&nombreCaseta="+ nombreCaseta + "&nombreCalle="+ nombreCalle + "&aforoMaximo="+ aforoMaximo + 
					"&aforoActual="+ aforoActual + "&horario="+ horario +"&tipoCaseta="+ tipoCaseta +"&idPropietario="+ idPropietario;
			
			try {
				LogFeriapp.peticionHttp(url);
				JOptionPane.showMessageDialog(null, "La caseta se ha creado correctamente");
			} catch (Exception e) {
				LogFeriapp.error(e.getMessage());
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Error al crear caseta", JOptionPane.ERROR_MESSAGE);
		}
		
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
		
		if(camposVacios()) {
			bExito = false;
		}
		else {
			bExito = true;
		}
		return bExito;
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
