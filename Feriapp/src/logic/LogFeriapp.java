package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

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

}
