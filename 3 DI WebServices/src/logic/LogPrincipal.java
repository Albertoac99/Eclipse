package logic;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Producto;
import view.Principal;

public class LogPrincipal {

	public static void introducirProducto() {
		
		
		
		
		
		
		
	}
	
	public static void actualizarProducto() {
		
		
		
		
		
	}
	
public static List<Producto> JsonToProductos(String respuesta) {
		
		List<Producto> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(respuesta);
		
		for(int i= 0; i<jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			
			Producto c = JsonToProducto(jsonO);
					
			lstResultado.add(c);
			
		}
		
		
		
		return lstResultado;
	}

	private static Producto JsonToProducto(JSONObject jsonO) {
		
		String codigo = jsonO.getString("codigo");
		
		String nombre = jsonO.getString("nombre");
		
		int stockActual = jsonO.getInt("stockActual");
		
		int stockMinimo = jsonO.getInt("stockMinimo");
		
		int stockMaximo = jsonO.getInt("stockMaximo");
		
		int opcion = jsonO.getInt("opocion");
		
		String comentario = jsonO.getString("comentario");
		
		int proveedor = jsonO.getInt("proveedor");
		
		boolean fragil = jsonO.getBoolean("fragil");
		
		boolean obsoleto = jsonO.getBoolean("obsoleto");
		 
		float pvp = jsonO.getFloat("pvp");
		
		Producto c = new Producto(codigo, nombre, stockActual,
				stockMinimo, stockMaximo, opcion, comentario,
				proveedor, fragil, obsoleto, pvp);
		
		 
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


	public static int opcion() {
		
		int resultado=0;
		
		if(Principal.rdbtnNewRadioButton.isSelected()) {
			
			resultado=1;
		}
		else if(Principal.rdbtnNewRadioButton_1.isSelected()) {
			resultado=2;
		}
		
		else if(Principal.rdbtnNewRadioButton_2.isSelected()) {
			resultado=3;
		}
		
		
		return resultado;
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

	public static int opcionSelecionada() {
		
		if(Principal.productos.get(Principal.position).getOpcion()==1) {
			return 1;
		}
		
		else if(Principal.productos.get(Principal.position).getOpcion()==2) {
			return 2;
		}
		else if(Principal.productos.get(Principal.position).getOpcion()==3) {
			return 3;
		}
		else {
			return 0;
		}
		
		
	}

	public static boolean comprobacionPosicion(int i) {
		
		if((Principal.position==0 && i==-1) || (Principal.position==Principal.productos.size()-1 && i==1)
				|| (Principal.position==Principal.productos.size() && i==1)) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public static boolean comprobacionStocks() {
		
		
		try {
		int stockActual = Integer.parseInt(Principal.textField_2.getText());
		int stockMinimo = Integer.parseInt(Principal.textField_3.getText());
		int stockMaximo = Integer.parseInt(Principal.textField_4.getText());
		float pvp = Float.parseFloat(Principal.textField_5.getText());
		
		if(stockActual>=stockMinimo && stockActual<=stockMaximo && stockMinimo>=0 && stockMaximo>stockMinimo
				&& pvp>=0) {
			return true;
		}
		else {
		return false;
		}
		}catch(NumberFormatException e) {
			return false;
		}
		
	}
}
