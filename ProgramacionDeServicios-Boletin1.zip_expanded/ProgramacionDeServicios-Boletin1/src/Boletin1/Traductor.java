package Boletin1;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import validaciones.ValidaLibrary;

public class Traductor {

public static void main(String[] args) {
		
		int iOpcion, iRepeti;
		float fTiempo;
		
		fTiempo = (float) ValidaLibrary.valida("Introduzca el tiempo de espera en segundos (1-100): ", 1, 100, 2);
		
		String sUrl = "https://translate.google.es/?hl=";
		
		iOpcion = (int) ValidaLibrary.valida("Elija el idioma que desea traducir: \n1- Español-Inglés\n2- Inglés-Español", 1, 2, 1);
		
		if(iOpcion==1) {
		try {
			sUrl += "es&tl=en&text=";
			sUrl += ValidaLibrary.leer("Introduzca la frase que quiera traducir: ");
			sUrl = sUrl.replace(" ","%20");
			URL url = new URL(sUrl);
			//https://translate.google.es/?hl=en&tl=es&text=hi%20my%20name
			Desktop.getDesktop().browse(url.toURI());
			
			
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (URISyntaxException e) {
		
			e.printStackTrace();
		}
		
		}
		else {
			try {
				sUrl += "en&tl=es&text=";
				sUrl += ValidaLibrary.leer("Introduzca la frase que quiera traducir: ");
				sUrl = sUrl.replace(" ","%20");
				URL url = new URL(sUrl);
				Desktop.getDesktop().browse(url.toURI());
				
				
			} catch (MalformedURLException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (URISyntaxException e) {
			
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep((long) (fTiempo*1000));
		} catch (InterruptedException e) {
			System.err.println("Error");
		}
		
		iRepeti = (int) ValidaLibrary.valida("¿Desea volver a traducir?\n1- Si\n2- No", 1, 2, 1);
		
		
		
		while(iRepeti==1) {
			sUrl = "https://translate.google.es/?hl=";
			
			iOpcion = (int) ValidaLibrary.valida("Elija el idioma que desea traducir: \n1- Español-Inglés\n2- Inglés-Español", 1, 2, 1);
			
			if(iOpcion==1) {
			try {
				sUrl += "es&tl=en&text=";
				sUrl += ValidaLibrary.leer("Introduzca la frase que quiera traducir: ");
				sUrl = sUrl.replace(" ","%20");
				URL url = new URL(sUrl);
				//https://translate.google.es/?hl=en&tl=es&text=hi%20my%20name
				Desktop.getDesktop().browse(url.toURI());
				
				
			} catch (MalformedURLException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (URISyntaxException e) {
			
				e.printStackTrace();
			}
			
			}
			else {
				try {
					sUrl += "en&tl=es&text=";
					sUrl += ValidaLibrary.leer("Introduzca la frase que quiera traducir: ");
					sUrl = sUrl.replace(" ","%20");
					URL url = new URL(sUrl);
					Desktop.getDesktop().browse(url.toURI());
					
					
				} catch (MalformedURLException e) {
				
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (URISyntaxException e) {
				
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep((long) (fTiempo*1000));
			} catch (InterruptedException e) {
				System.err.println("Error");
			}
			
			iRepeti = (int) ValidaLibrary.valida("¿Desea volver a traducir?\n1- Si\n2- No", 1, 2, 1);
			
		}
		
	}
}
