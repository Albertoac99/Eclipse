import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class P5 {
	
	
	public class Control{
			
		Queue<Estudiante> estudiantesDiscord = new LinkedList<Estudiante>();
		Queue<Estudiante> estudiantesGoogle = new LinkedList<Estudiante>();
		Semaphore oSemaforo = new Semaphore(0);
			
			
		}
	
	final Control control = new Control();
	
	public class Estudiante implements Runnable{

		private int id;
		
		public Estudiante(int id) {
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
			
			
			
			if(random()==1) {
				control.estudiantesDiscord.add(this);
				control.oSemaforo.release();
			}
			else {
				control.estudiantesGoogle.add(this);
				control.oSemaforo.release();
			}
			
		}
		
	}
	
	public class Profesor implements Runnable{

		
		
		
		@Override
		public void run() {
			
			try {
				
				while(true) {
				
				control.oSemaforo.acquire();
				System.out.println("Tamaño discord: "+control.estudiantesDiscord.size()+"\nTamaño google: "+control.estudiantesGoogle.size());
				if(control.estudiantesDiscord.size()>control.estudiantesGoogle.size()) {
					
					System.out.println("El profesor está atendiendo al alumno "+control.estudiantesDiscord.poll().getId()+" por Discord");
					
				}
				else if(control.estudiantesGoogle.size()>control.estudiantesDiscord.size()) {
					System.out.println("El profesor está atendiendo al alumno "+control.estudiantesGoogle.poll().getId()+" por Google Meet");
				}
				else {
					
					if(random()==1) {
						
						System.out.println("El profesor está atendiendo al alumno "+control.estudiantesDiscord.poll().getId()+" por Discord");
					}
					else {
						System.out.println("El profesor está atendiendo al alumno "+control.estudiantesGoogle.poll().getId()+" por Google Meet");
					}
					
					
				}
				
				Thread.sleep(10000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private int random() {
		
		return (int) (Math.random()*2+1);
	}
	
	private void executeMultiThreading() throws InterruptedException {
		int iContador=0;
		new Thread(new Profesor()).start();
		
		while(true) {
			
			Thread.sleep((long) ((Math.random()*4+1)*1000));
			
			new Thread(new Estudiante(iContador)).start();
			iContador++;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		P5 oP5 = new P5();
		
		try {
			oP5.executeMultiThreading();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

}
}
