package view;

import java.io.DataInputStream;
import java.io.IOException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Servidor {
	
	final int PUERTO = 5555;
	
	
	public class Recibir implements Runnable{

		@Override
		public void run() {
			
			try {
				
			SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
	        SSLServerSocket servidorSSL = (SSLServerSocket) sfact.createServerSocket(PUERTO);
	        SSLSocket clienteConectado = null;
			DataInputStream entradaMensaje;

				while (true) {
					
					System.out.println("Servidor iniciado");
					
					clienteConectado = (SSLSocket) servidorSSL.accept();
					
					System.out.println("Mensaje recibido");

					entradaMensaje = new DataInputStream(clienteConectado.getInputStream());

					String mensaje = entradaMensaje.readUTF();
					
					System.out.println("Informando a las autoridades sobre la persona con id: "+mensaje);

					entradaMensaje.close();
					clienteConectado.close();
				}
			} catch (IOException e) {
				System.err.println("Error " + e.getMessage());
			}
			
		}
		
	}
	
	

	public void executeMultiThreading() {
		
		System.setProperty("javax.net.ssl.keyStore", "keytool/socketKey.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","medac2020");
        System.setProperty("javax.net.ssl.trustStore", "keytool/clientTrustedCerts.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "medac2020");

		new Thread(new Recibir()).start();
		
	}
	
	

	public static void main(String args[]) {

		try {
			Servidor conexion = new Servidor();
			conexion.executeMultiThreading();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
