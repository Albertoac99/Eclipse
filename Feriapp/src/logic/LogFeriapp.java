package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
import model.Caseta;
import model.Cuenta;


public class LogFeriapp {
	
	
	public static void errorIniciar() {
		
		JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
	}

	public static void errorCrear() {
		
		JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre, por favor introduca otro", "Error al crear usuario", JOptionPane.ERROR_MESSAGE);
	}
	
	public static List<Cuenta> JsonToCuentas(String respuesta) {
		
		List<Cuenta> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(respuesta);
		
		for(int i= 0; i<jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			
			Cuenta c = JsonToCuenta(jsonO);
					
			lstResultado.add(c);
			
		}
		
		return lstResultado;
	}

	private static Cuenta JsonToCuenta(JSONObject jsonO) {
		
		 int idCuenta = jsonO.getInt("idCuenta");
		 String usuario = jsonO.getString("usuario");
		 String contrasenia = jsonO.getString("contrasenia");
		 int tipoUsuario = jsonO.getInt("tipoUsuario");
		
		 Cuenta c = new Cuenta(idCuenta,usuario,contrasenia,tipoUsuario);
		
		return c;
	}
	
	public static String JsonToComprobarCuenta(String respuesta) {
		
		String nombreCuenta = null;
		
		JSONArray jsonA = new JSONArray(respuesta);
		
		for(int i= 0; i<jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			
			nombreCuenta = JsonToComprobarCuentas(jsonO);
					
		}
		
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
		String fileName = ""+ContLogueo.lstCuentas.get(0).getIdCuenta();
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
		
		JOptionPane.showMessageDialog(null,"La imagen ha sido subida correctamente", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
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
	

}
