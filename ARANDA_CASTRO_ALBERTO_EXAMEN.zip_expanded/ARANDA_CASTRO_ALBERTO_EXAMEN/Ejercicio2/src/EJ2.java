import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EJ2 {

	public class Control{
		
		private float fRadio;
		private final float PI = (float) 3.1416;

		public float getfRadio() {
			return fRadio;
		}

		public void setfRadio(float fRadio) {
			this.fRadio = fRadio;
		}
		
		
		
		
		
	}
	
	final Control control = new Control();
	
	public class LongitudCircunferencia implements Runnable{

		@Override
		public void run() {
			
			float fLongitud;
			
			fLongitud = control.fRadio * 2 * control.PI;
			
			System.out.println("La longitud de la circunferencia es: "+fLongitud);
			
			
		}
		
		
		
	}
	
	public class SuperficieCircunferencia implements Runnable{

		@Override
		public void run() {
			
			float fSuperficie;
			
			fSuperficie = (float) (4 * control.PI * Math.pow(control.fRadio, 2));
			
			System.out.println("La superficie de la circunferencia es: "+fSuperficie);
			
		}
		
		
		
	}
	public class VolumenEsfera implements Runnable{

		@Override
		public void run() {
			
			float fVolumen;
			
			fVolumen = (float) ((4/3) * control.PI * Math.pow(control.fRadio, 3));
			
			System.out.println("El volumen de la esfera es: "+fVolumen);
			
		}
		
		
		
	}
	public class AreaEsfera implements Runnable{

		@Override
		public void run() {
			
			float fArea;
			
			fArea = (float) (control.PI * Math.pow(control.fRadio, 2));
			
			System.out.println("El área de la esfera es: "+fArea);
			
			
		}
		
		
		
	}
	
	private void executeMultiThreading() throws NumberFormatException, IOException, InterruptedException {
		List<Thread> hilos = new ArrayList<Thread>();
		
		control.setfRadio(2);
		
		hilos.add(new Thread(new LongitudCircunferencia()));
		hilos.add(new Thread(new SuperficieCircunferencia()));
		hilos.add(new Thread(new VolumenEsfera()));
		hilos.add(new Thread(new AreaEsfera()));
		
		for(int iContador=0;iContador<4;iContador++) {
			
		hilos.get(iContador).start();
			
		}
		
		for(int iContador=0;iContador<4;iContador++) {
			
			hilos.get(iContador).join();
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		
		
		
		EJ2 oEJ2 = new EJ2();
		
		oEJ2.executeMultiThreading();
		

	}

}
