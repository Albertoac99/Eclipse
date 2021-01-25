package controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CtrPrincipal {
	private static File archivo;

	public static void seleccionarFichero() {
		JFileChooser selectorArchivos = new JFileChooser();

		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(null);
		try {

			archivo = selectorArchivos.getSelectedFile();

			Image image = ImageIO.read(archivo);

			view.FrmPrincipal.foto.setIcon(new ImageIcon(image));

			view.FrmPrincipal.txtFileName.setText(archivo.getAbsolutePath());

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void download() {

		//String path = "https://www.a-alvarez.com/productsimages/PACK-10DIANA-PAPEL-37135-AR100100.jpg/450/fill/ffffff";

		String fileName = view.FrmPrincipal.txtFileName.getText().toString();
		String path = "https://arandacastroalberto.000webhostapp.com/" +fileName + ".jpg";
		
		try {
			URL url = new URL(path);

			Image image = ImageIO.read(url);

			view.FrmPrincipal.foto.setIcon(new ImageIcon(image));

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void upload() {
		
		if(view.FrmPrincipal.txtFileName.getText().length() == 0) {
			
			JOptionPane.showMessageDialog(null,"Debes indicar un nombre de imagen", "FALLO", JOptionPane.ERROR_MESSAGE);
			return;
			
		}
		
		try {
			
			String filePath = archivo.getAbsolutePath();
			String fileName = archivo.getName();
			String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
			
			String path = "http://albertoarandamedac.tk/images/imagen.php";
			
			//Establecer conexion...
			URL url = new URL(path);
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
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,e.getMessage(), "UPLOAD", JOptionPane.ERROR_MESSAGE);
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

























