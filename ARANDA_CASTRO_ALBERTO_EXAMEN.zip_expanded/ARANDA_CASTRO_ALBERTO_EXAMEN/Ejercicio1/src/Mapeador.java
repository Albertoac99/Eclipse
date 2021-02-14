import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Mapeador {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		String sURL;
		boolean bRepetir = true;
		double dEjeX;
		double dEjeY;
		
		
		do {
			
			Thread.sleep((long) ((Math.random()*6+3)*1000));
			
			sURL= "http://www.google.es/maps/place/";
			
			dEjeX = Math.random()*80+1;
			dEjeY = Math.random()*80+1;
			
			sURL += dEjeX+",+"+dEjeY;
			
			System.out.println("La url es: "+sURL);
			
			URL url = new URL(sURL);
			Desktop.getDesktop().browse(url.toURI());
			
		
		}while(bRepetir);

	}

}
