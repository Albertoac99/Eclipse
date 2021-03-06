package controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import logic.LogFeriapp;
import model.Cuenta;
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

			Perfil.lblFotoPerfil.setIcon(new ImageIcon(image.getScaledInstance(114, 113, Image.SCALE_SMOOTH)));


		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void download() {

		String fileName = ""+ContLogueo.lstCuentas.getIdCuenta();
		String path = "https://arandacastroalberto.000webhostapp.com/php/imagenes/" +fileName + ".jpg";
		
		try {
			URL url = new URL(path);

			Image image = ImageIO.read(url);

			Perfil.lblFotoPerfil.setIcon(new ImageIcon(image.getScaledInstance(114, 113, Image.SCALE_SMOOTH)));

		} catch (Exception e) {
			File imagen = new File("img\\silueta.jpg");
			Image image = null;
			try {
				image = ImageIO.read(imagen);
			} catch (IOException e1) {
				LogFeriapp.error(e1.getMessage());
			}
			Perfil.lblFotoPerfil.setIcon(new ImageIcon(image.getScaledInstance(114, 113, Image.SCALE_SMOOTH)));
		}

	}

	public static void upload() {
			
			String path = "https://arandacastroalberto.000webhostapp.com/php/imagen.php";
			LogFeriapp.subirImagen(path);
			JOptionPane.showMessageDialog(null,"La imagen ha sido subida correctamente", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
			
	}

	public static void guardarCambios() {
		
		String usuarioNuevo = Perfil.txtNuevoUsuario.getText().toString();
		String contraseniaNueva = Perfil.txtNuevaContrase�a.getText().toString();
		String usuario = ContLogueo.lstCuentas.getUsuario();
		
		String url = "https://arandacastroalberto.000webhostapp.com/php/updateUsuario.php?usuarioNuevo="+usuarioNuevo+"&contraseniaNueva="+contraseniaNueva+"&usuario="+usuario;
		
		try {
			LogFeriapp.peticionHttp(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null,"Los datos han sido actulizados correctamente", "UPLOAD", JOptionPane.INFORMATION_MESSAGE);
		
		ContLogueo.lstCuentas = new Cuenta(ContLogueo.lstCuentas.getIdCuenta(),usuarioNuevo, contraseniaNueva, ContLogueo.lstCuentas.getTipoUsuario());
	}
	

}
