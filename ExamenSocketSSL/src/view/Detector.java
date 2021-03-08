package view;

import java.io.DataOutputStream;
import java.io.IOException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Detector {
	
	final int PUERTO = 5555;
	
	private static String HOST = "192.168.31.235";
	
	
	public class Enviador implements Runnable{
		
		private int id;

		public Enviador(int id) {
			super();
			this.id = id;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			
			if(temperaturaSobrepasada()) {
				
				try {
					SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
			        SSLSocket cliente = (SSLSocket) sfact.createSocket(HOST, PUERTO);
					
					DataOutputStream mensaje = new DataOutputStream(cliente.getOutputStream());

					mensaje.writeUTF(""+this.id);
					
					cliente.close();
					mensaje.close();
					
					Thread.sleep(2000);
					
					
				} catch (IOException e) {
					System.err.println("Error al conectar");

				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
			else {
				
				System.out.println("Puede usted continuar");
				
			}
			
		}

		private boolean temperaturaSobrepasada() {
			boolean tempSobrepasada;
			int iGrados = 0;

			iGrados = (int) ((Math.random() * 40) + 20);
			System.out.println(iGrados);
			
			if(iGrados>37.5) {
				tempSobrepasada=true;
			}
			else {
				tempSobrepasada=false;
			}
			
			return tempSobrepasada;
		}
		
	}
	
	
	private void executeMultiThreading() throws InterruptedException {
		
		System.setProperty("javax.net.ssl.keyStore", "keytool/socketKey.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","medac2020");

		for (int j = 0; j < 5; j++) {
			new Thread(new Enviador(+j)).start();
		}
		
	}

	public static void main(String[] args) {
		
		try {
			Detector detector = new Detector();
			detector.executeMultiThreading();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
