package controller;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class CtrPrincipal {

	public static void seleccionarFichero() {
		JFileChooser selectorArchivos = new JFileChooser();

		selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		selectorArchivos.showOpenDialog(null);
		try {

			File archivo = selectorArchivos.getSelectedFile();

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

	}

}
