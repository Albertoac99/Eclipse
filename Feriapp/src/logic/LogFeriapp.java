package logic;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.ContLogueo;
import controller.ContPerfil;
import model.Calle;
import model.Caseta;
import model.Cuenta;


public class LogFeriapp {
	
	public static boolean salir() {
		boolean bSalir;
		if (JOptionPane.showConfirmDialog(null, "¿Desea salir de Feriapp?", "Confirmar Salir", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			bSalir = true;
		}
		else {
			bSalir = false;
		}
		return bSalir;
	}
	
	public static void error(String e) {
		JOptionPane.showMessageDialog(null, "Error: "+e, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static Cuenta JsonToCuentas(String respuesta) {
		
		Cuenta resultado = null;
		
		JSONObject jsonA = new JSONObject(respuesta);
	
		resultado = JsonToCuenta(jsonA);
		
		return resultado;
	}

	private static Cuenta JsonToCuenta(JSONObject jsonO) {
		
		 int idCuenta = jsonO.getInt("idCuenta");
		 String usuario = jsonO.getString("usuario");
		 String contrasenia = jsonO.getString("contrasenia");
		 int tipoUsuario = jsonO.getInt("tipoUsuario");
		
		 Cuenta c = new Cuenta(idCuenta,usuario,contrasenia,tipoUsuario);
		
		return c;
	}
	
	public static List<Calle> JsonToCalles(String respuesta) {
		
		List<Calle> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(respuesta);
		
		for(int i= 0; i<jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			
			Calle c = JsonToCalle(jsonO);
					
			lstResultado.add(c);
			
		}
		
		return lstResultado;
	}

	private static Calle JsonToCalle(JSONObject jsonO) {

		 String nombreCalle = jsonO.getString("nombreCalle");
		
		 Calle c = new Calle(nombreCalle);
		
		return c;
	}
	
	public static String JsonToComprobarCuenta(String respuesta) {
		
		String nombreCuenta = null;
		
		JSONObject jsonA = new JSONObject(respuesta);
			
		nombreCuenta = JsonToComprobarCuentas(jsonA);
		
		return nombreCuenta;
	}

	private static String JsonToComprobarCuentas(JSONObject jsonO) {
		
		 String usuario = jsonO.getString("usuario");
		
		return usuario;
	}
	
	public static List<Caseta> JsonToCasetas(String respuesta) {
		
		List<Caseta> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(respuesta);
		
		for(int i= 0; i<jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			
			Caseta c = JsonToCaseta(jsonO);
					
			lstResultado.add(c);
			
			
		}
		
		return lstResultado;
	}

	private static Caseta JsonToCaseta(JSONObject jsonO) {
		
		 int numeroCaseta = jsonO.getInt("numeroCaseta");
		 String nombreCaseta = jsonO.getString("nombreCaseta");
		 String nombreCalle = jsonO.getString("nombreCalle");
		 int aforoMaximo = jsonO.getInt("aforoMaximo");
		 int aforoActual = jsonO.getInt("aforoActual");
		 String horario = jsonO.getString("horario");
		 int tipoCaseta = jsonO.getInt("tipoCaseta");
		 int idPropietario= jsonO.getInt("idPropietario");
		 
		 Caseta c = new Caseta(numeroCaseta, nombreCaseta, nombreCalle, aforoMaximo, aforoActual, horario, tipoCaseta, idPropietario);
		
		return c;
	}

	public static String peticionHttp(String urlWebService) throws Exception{
		
		StringBuilder resultado = new StringBuilder();
		
		URL url = new URL(urlWebService);
		
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		
		conexion.setRequestMethod("GET");
		
		//Recoger los datos de respuesta
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		
		String linea;
		
		while((linea = rd.readLine()) != null) {
			
			resultado.append(linea);
			
		}
		
		
		rd.close();
		
		return resultado.toString();
	}
	
	public static void subirImagen(String ruta) {
	try {	
		String filePath = ContPerfil.archivo.getAbsolutePath();
		String fileName = ""+ContLogueo.lstCuentas.getIdCuenta();
		String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
		
		//Establecer conexion...
		URL url;
		
			url = new URL(ruta);
		
		URLConnection con = url.openConnection();
		HttpURLConnection http = (HttpURLConnection) con;
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		
		// Parámetros de envío
		Map<String, String> params = new HashMap<>();
		params.put("imagenName", fileNameWithOutExt);
		params.put("imagenData", encoderFileToBase64(filePath));
		
		// Array de Bytes de envío
		StringJoiner sj = new StringJoiner("&");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		byte [] out = sj.toString().getBytes(StandardCharsets.UTF_8);
		
		// Enviar el array de bytes hacia el path (URL del Web-Service)
		http.setFixedLengthStreamingMode(out.length);
		http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		http.connect();
		http.getOutputStream().write(out);
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String encoderFileToBase64(String filePath) {
		
		String base64Image = "";
		File file = new File(filePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			
			byte imageData [] = new byte [ (int) file.length() ];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "FALLO", JOptionPane.ERROR_MESSAGE);
		}
		
		return base64Image;
	}
	
	public static boolean caracteres(KeyEvent e) {
		if(e.getKeyChar()!="0".charAt(0) && e.getKeyChar()!="1".charAt(0) && e.getKeyChar()!="2".charAt(0) && e.getKeyChar()!="3".charAt(0) && e.getKeyChar()!="4".charAt(0) 
				&& e.getKeyChar()!="5".charAt(0) && e.getKeyChar()!="6".charAt(0) && e.getKeyChar()!="7".charAt(0) && e.getKeyChar()!="8".charAt(0) &&
				e.getKeyChar()!="9".charAt(0)) {
			return true;
			
		}
		else {
			return false;
		}
	}

	public static String tipoCaseta(Caseta c) {
		String resultado;
		
		if(c.getTipoCaseta() == 1) {
			resultado = "Privada";
		}
		else {
			resultado = "Pública";
		}
		
		return resultado;
	}
	
	public static void writeDataObject(String FILE_NAME, List<Cuenta> listado) {
		try {
			
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			for(Cuenta c : listado) {
				fch.writeObject(c);
			}
			fch.close();	
		} catch (FileNotFoundException e) {
			error(e.getMessage());
		} catch (IOException e) {
			error(e.getMessage());
		}
		
	}
	
	public static List<Cuenta> readDataObject(String FILE_NAME) {
		List<Cuenta> listado = new ArrayList<Cuenta>();
		
		try {
			
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			Object obj = fch.readObject();
			
				if(obj instanceof Cuenta) {
					listado.add((Cuenta) obj);
				}
				
			fch.close();
		} catch (IOException e) {
			error(e.getMessage());
		} catch (ClassNotFoundException e) {
			error(e.getMessage());
		}
		return listado;
	}

	public static Caseta JsonToCasetas2(String respuesta) {
		Caseta lstResultado;
		
		JSONObject jsonA = new JSONObject(respuesta);
			
		lstResultado = JsonToCaseta(jsonA);
					
		return lstResultado;
	}
	

}
