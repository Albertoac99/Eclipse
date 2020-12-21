package app;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Coche;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PrincipalPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalPanel frame = new PrincipalPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public PrincipalPanel() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String url = "http://albertoarandamedac.tk/marcasCoches.php";
		String respuesta = peticionHttp(url);
		
		List<Coche> lstCoches = JsonToCoches(respuesta);
		
		Choice cho = new Choice();
		
		List<String> lista = new ArrayList<>();
		
		lstCoches.forEach((c) -> lista.add(c.toMarca()));
		
		for(int i = 0;i<lista.size();i++) {
			
			cho.add(lista.get(i));
		}
		
		
		
		
		
		contentPane.add(cho, BorderLayout.CENTER);
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
		
		 String marca = jsonO.getString("marca");
		
		Coche c = new Coche(marca);
		
		 
		 
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
