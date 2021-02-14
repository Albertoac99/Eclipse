import java.util.concurrent.Semaphore;


public class EJ3 {
public class Control{
		
		double resultado;
		int x=1;
		int y=1;
		Semaphore oSemaphoreP1 = new Semaphore(0);
		Semaphore oSemaphoreP2 = new Semaphore(0);
    	
	}
	
	final Control control = new Control();
	
	public class P1 implements Runnable{
		
		
		@Override
		public void run() {
			
			try {
				
				
				int i=0;
				int resultado;
				
				while(true) {
					
					
					
					
					control.oSemaphoreP1.acquire();
					resultado=1;
					i++;
					
				for(int iContador = 0;iContador<i;iContador++) {
			
				resultado*= i-iContador;
			
				}
				
				control.x = resultado;
				control.oSemaphoreP2.release();
				
				System.out.println("X: "+ control.x);
				Thread.sleep(1000);
				
				control.oSemaphoreP1.release();
				control.oSemaphoreP2.acquire();
			}
				
				
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			
			
			
		}		
		
	}
	
	
	public class P2 implements Runnable{

		


		@Override
		public void run() {
			
			try {
				
				
			int j=0;
			int resultado;
			
			while(true) {
				
				j++;
				
				
				
				control.oSemaphoreP1.release();
				control.oSemaphoreP2.acquire();
				resultado=1;
			
			for(int iContador=1;iContador<=j;iContador++) {
				
				resultado*=iContador;
				
				}
			
			control.y=resultado;
			System.out.println("Y: " +control.y);
			Thread.sleep(1000);
			
			control.oSemaphoreP1.acquire();
			
			System.out.println("El resultado es : " +(control.x/control.y));
			
			control.oSemaphoreP2.release();
			
			}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void executeMultiThreading () {
    	    	
		
		new Thread(new P1()).start();
		new Thread(new P2()).start();
	
		
		    
		}

	public static void main(String[] args) {
		try {
			EJ3 oEJ3 = new EJ3();
			oEJ3.executeMultiThreading();
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

	}
}
