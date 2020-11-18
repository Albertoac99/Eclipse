import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class P1 {
	
public class Control {
    	
    	Semaphore oSemaforoVisitante = new Semaphore(0);
    	Semaphore oSemaforoCoche = new Semaphore(2);
    	Queue<HiloPasajero> cola = new LinkedList<HiloPasajero>();

		public Semaphore getoSemaforoVisitante() {
			return oSemaforoVisitante;
		}

		public void setoSemaforoVisitante(Semaphore oSemaforoVisitante) {
			this.oSemaforoVisitante = oSemaforoVisitante;
		}

		public Semaphore getoSemaforoCoche() {
			return oSemaforoCoche;
		}

		public void setoSemaforoCoche(Semaphore oSemaforoCoche) {
			this.oSemaforoCoche = oSemaforoCoche;
		}
    	
    }


    final Control control = new Control();
	
    public class HiloCoche implements Runnable{
    	
    	private int iId;

		public HiloCoche(int iId) {
			setiId(iId);
		}

		public int getiId() {
			return iId;
		}
		
		public void setiId(int iId) {
			this.iId = iId;
		}



		@Override
		public void run() {
			
			int recorrido = 3000;
			
			
			while(true) {
			try {
				
				control.oSemaforoCoche.acquire();
				control.oSemaforoVisitante.acquire();
				
				int numero = control.cola.poll().getiId();
				System.err.println("El visitante "+ numero + " se ha montado en el coche " +getiId());
				System.err.println("El coche " +getiId()+ " ha empezado el recorrido");
				
				Thread.sleep(recorrido);
				
				System.err.println("El coche " +getiId()+ " ha terminado el recorrido");
				
				System.err.println("El visitante "+numero+ " ha salido de la atracción");
				
				control.oSemaforoCoche.release();
				
				Thread.sleep(1000);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

				
			}
			
			}
			
    	
    }
	

	public class HiloPasajero implements Runnable {

    	private int iId;

	public HiloPasajero(int iId) {
	    setiId(iId);
	}

	public int getiId () {
	    return iId;
	}

	public void setiId (int iId) {
	    this.iId = iId;
	}

	
	@Override
	public synchronized void run () {
		
		int tiempoLlegada = (int)(Math.random()*5+1);
		
	    System.out.println("Visitante " + this.getiId() + " llegando a la estación en " +tiempoLlegada+" segundos.");

	    try {
			Thread.sleep(tiempoLlegada*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    control.cola.add(this);
	    
	    control.oSemaforoVisitante.release();

	}
    }
	
	
	
	private void executeMultiThreading () {
		

		final int NUMCOCHES = 4;
		
		int iContador;		
		
		// Creando coches
		for (iContador = 0; iContador < NUMCOCHES; iContador++) {
		    System.out.println("Creando el hilo " + iContador + ".");
		   new Thread(new HiloCoche(iContador)).start();
		   
		}

		
		
		
		iContador = 0;

		// Creando visitantes
		while(true) {
		    //System.out.println("Creando el hilo " + iContador + ".");
		    new Thread(new HiloPasajero(iContador)).start();
		    iContador++;
		    try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    
		}
		    
		}
		
	
	public static void main(String[] args) {
		
		try {
			P1 oP1 = new P1();
		    oP1.executeMultiThreading();
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
	}

}
