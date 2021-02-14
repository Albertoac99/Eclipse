package Boletin1;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import validaciones.ValidaLibrary;

public class EJ1_NavegadorWeb {

	public static void main(String[] args) {
		byte i = 0;
		String sURL;
		
		sURL = ValidaLibrary.leer("Introduce la URL: ");
		while (i==0) {
			
			try {
				
				URL url = new URL(sURL);
				Desktop.getDesktop().browse(url.toURI());
				
				Thread.sleep(10000);
				sURL = ValidaLibrary.leer("Introduce la URL: ");
			}catch(IOException e) {
				String sHTTP = "http://";
				sHTTP += sURL;
				sURL=sHTTP;
				
			}catch(InterruptedException ex) {
				
				System.out.println("ERROR IE: " + ex.getMessage());
				System.exit(-1);
				
			}catch (URISyntaxException e) {
				
		        e.printStackTrace();
		        
		    }
		
		}

	}

}
