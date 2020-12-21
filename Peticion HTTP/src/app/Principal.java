package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Coche;

public class Principal {

	public static List<Coche> lstCoches;
	public static void main(String[] args) {
		
	try {
		
	String url = "http://albertoarandamedac.tk/consulta1.php";
	String respuesta = peticionHttp(url);
	
	lstCoches = JsonToCoches(respuesta);
	
	lstCoches.forEach((c) -> System.out.println(c));
	
	
	
	//System.out.println(respuesta);
	}catch(Exception e) {
		
		System.out.println(e.getMessage());
	}

	}

	private static List<Coche> JsonToCoches(String respuesta) {
		
		List<Coche> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(respuesta);
		
		for(int i= 0; i<jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			
			Coche c = JsonToCoche(jsonO);
					
			lstResultado.add(c);
			
			
		}
		
		
		
		return lstResultado;
	}

	private static Coche JsonToCoche(JSONObject jsonO) {
		
		 int id_coche = jsonO.getInt("id_coche");
		 String marca = jsonO.getString("marca");
		 String modelo = jsonO.getString("modelo");
		 Integer potencia = jsonO.getInt("potencia");
		
		Coche c = new Coche(id_coche,marca,modelo,potencia);
		
		 
		 
		return c;
	}

	private static String peticionHttp(String urlWebService) throws Exception{
		
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
