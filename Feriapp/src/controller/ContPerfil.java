package controller;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import logic.LogFeriapp;
import view.Perfil;

public class ContPerfil {
	public static File archivo;

	public static void seleccionarFichero() {
		JFileChooser selectorArchivos = new JFileChooser();

		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(null);
		try {

			archivo = selectorArchivos.getSelectedFile();

			Image image = ImageIO.read(archivo);

			Perfil.lblFotoPerfil.setIcon(new ImageIcon(image));


		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void download() {

		String fileName = ""+ContLogueo.lstCuentas.get(0).getIdCuenta();
		String path = "https://arandacastroalberto.000webhostapp.com/php/imagenes/" +fileName + ".jpg";
		
		try {
			URL url = new URL(path);

			Image image = ImageIO.read(url);

			Perfil.lblFotoPerfil.setIcon(new ImageIcon(image.getScaledInstance(114, 113, Image.SCALE_SMOOTH)));

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void upload() {
			
			String path = "https://arandacastroalberto.000webhostapp.com/php/imagen.php";
			LogFeriapp.subirImagen(path);
			
	}
	

}
