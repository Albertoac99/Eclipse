import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class P4 {
	
	public class Control{
		Queue<EstudianteAbajo> abajo = new LinkedList<EstudianteAbajo>();
		Queue<EstudianteArriba> arriba = new LinkedList<EstudianteArriba>();
		Semaphore oSemaforo = new Semaphore(1);
		
		
	}
	
	final Control control = new Control();
	
	public class EstudianteAbajo implements Runnable {


		@Override
		public void run() {
			try {
			while(true) {
				
				
				Thread.sleep((long) ((Math.random()*3+1)*1000));
				System.out.println("nuevo alumno en la cola de abajo");
				control.abajo.add(this);
				
				if(control.oSemaforo.availablePermits()==1 && control.abajo.size()>=10) {
					control.oSemaforo.acquire();
					for(int iContador =0; iContador<10;iContador++) {
						control.abajo.poll();
					}
					
					System.out.println("Estudiantes bajando...");
					Thread.sleep(2000);
					control.oSemaforo.release();
				}
				
			}
			}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
	public class EstudianteArriba implements Runnable{

		
		@Override
		public void run() {
			try {
			while(true) {
				
				Thread.sleep((long) ((Math.random()*3+1)*1000));
				System.out.println("Nuevo alumno en la cola de arriba");
				control.arriba.add(this);
				
				if(control.oSemaforo.availablePermits()==1 && control.arriba.size()>=10) {
					control.oSemaforo.acquire();
					for(int iContador =0; iContador<10;iContador++) {
						control.arriba.poll();
					}
					
					System.out.println("Estudiantes subiendo...");
					Thread.sleep(2000);
					control.oSemaforo.release();
				}
				
			}
			
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	private void executeMultiThreading() {
		
		new Thread(new EstudianteArriba()).start();
		new Thread(new EstudianteAbajo()).start();
		
	}
	
	

	public static void main(String[] args) {
		try {
		P4 oP4 = new P4();
		
		oP4.executeMultiThreading();
		}catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		
	}

}
