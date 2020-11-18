import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;



public class EJ4 {
	public class Control {
    	Semaphore oSemaforoDentista = new Semaphore(1);
    	Semaphore oSemaforoEspera = new Semaphore(0);
    	Queue<Espera> cola = new LinkedList<Espera>();
    	
		public Semaphore getoSemaforoEspera() {
			return oSemaforoEspera;
		}
		public void setoSemaforoEspera(Semaphore oSemaforoEspera) {
			this.oSemaforoEspera = oSemaforoEspera;
		}
		public Semaphore getoSemaforoDentista() {
			return oSemaforoDentista;
		}
		public void setoSemaforoDentista(Semaphore oSemaforoDentista) {
			this.oSemaforoDentista = oSemaforoDentista;
		}
		

    }


    final Control control = new Control();
    
    public class Espera implements Runnable{

    	private int iID;
    	
		public Espera(int iID) {
			this.iID = iID;
		}
			
		public int getiID() {
			return iID;
		}

		public void setiID(int iID) {
			this.iID = iID;
		}

		@Override
		public void run() {
			
			if(control.cola.size()<10) {
				System.out.println("Cliente "+getiID()+" esperando");
				control.cola.add(this);
				control.oSemaforoEspera.release();
			}
			else {
				System.out.println("El cliente "+getiID()+" se va enfadado");
			}
			
			
		}
    	
    }
    
    public class Habitacion implements Runnable{

		@Override
		public void run() {
			try {
			
				while(true) {
					control.oSemaforoEspera.acquire();
					control.oSemaforoDentista.acquire();
				
					int numero = control.cola.poll().getiID();
					System.out.println("El cliente "+ numero + " está siendo atendido");
			
					Thread.sleep((long) ((Math.random()*10+1)*1000));
					
					System.out.println("El cliente "+ numero + " ha sido atendido");
					
					control.oSemaforoDentista.release();
				}
			
						
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
    	
    }
    
    private void executeMultiThreading () {
		
		int iContador=0;		
		
		// Creando dentista
		    System.out.println("Creando el hilo del dentista");
		   new Thread(new Habitacion()).start();
		   

		// Creando espera
		while(true) {
			
			try {
				
				long iEspera = (long) (Math.random()*2+1);
				
				System.out.println("Cliente llegando en " +iEspera+ " segundos");
				Thread.sleep(iEspera*1000);
				new Thread(new Espera(iContador)).start();
				
				iContador++;
			
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	
		}
		    
		}

	public static void main(String[] args) {
		try {
			EJ4 oEJ4 = new EJ4();
			oEJ4.executeMultiThreading();
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

	}

}
