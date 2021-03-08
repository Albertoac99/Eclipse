package view;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	final int PUERTO = 5555;
	
	
	public class Recibir implements Runnable{

		@Override
		public void run() {
			
			Socket socket;
			ServerSocket servidor = null;
			DataInputStream entradaMensaje;

			try {
				servidor = new ServerSocket(PUERTO);

				while (true) {
					
					System.out.println("Servidor iniciado");
					
					socket = servidor.accept();
					
					System.out.println("Mensaje recibido");

					entradaMensaje = new DataInputStream(socket.getInputStream());

					String mensaje = entradaMensaje.readUTF();
					
					System.out.println("Informando a las autoridades sobre la persona con id: "+mensaje);

					entradaMensaje.close();
					socket.close();
				}
			} catch (IOException e) {
				System.err.println("Error " + e.getMessage());
			}
			
		}
		
	}
	
	

	public void executeMultiThreading() {

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
