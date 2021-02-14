import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;



public class P2 {

	public class Control{
		

		Semaphore oSemaforoSerranito = new Semaphore(0);
    	Semaphore oSemaforoEstudiantes = new Semaphore(1);
    	Queue<Serranito> serranitos = new LinkedList<Serranito>();
    	Queue<Estudiante> cola = new LinkedList<Estudiante>();
    	
		public Semaphore getoSemaforoSerranito() {
			return oSemaforoSerranito;
		}
		public void setoSemaforoSerranito(Semaphore oSemaforoSerranito) {
			this.oSemaforoSerranito = oSemaforoSerranito;
		}
		public Semaphore getoSemaforoEstudiantes() {
			return oSemaforoEstudiantes;
		}
		public void setoSemaforoEstudiantes(Semaphore oSemaforoEstudiantes) {
			this.oSemaforoEstudiantes = oSemaforoEstudiantes;
		}
		
	}
	
	final Control control = new Control();
	
public class Serranito implements Runnable{
		
		private int iID;

		public Serranito(int iID) {
			super();
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
			while(true) {
			try {
				
				control.oSemaforoSerranito.acquire();
				System.out.println("empezando");
				
				int numero = control.cola.poll().getiID();
				int numeroplato =control.serranitos.poll().getiID();
				System.out.println("El estudiante numero "+numero+" ha cogido el serranito "+numeroplato);
				System.out.println(control.serranitos.size());
				if(control.serranitos.size()==0) {
					for(int iContador=0;iContador<5;iContador++) {
						control.serranitos.add(new Serranito(iContador));
					}
					
					System.out.println("El cocinero ha repuesto todos los serranitos");
					
				}
				System.out.println("terminando");
				control.oSemaforoEstudiantes.release();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}		
		
	}
	
	
	public class Estudiante implements Runnable{

		private int iID;
		
		public Estudiante(int iID) {
			super();
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
			
			try {
				
				while(true) {
					Thread.sleep(1000);
				control.oSemaforoEstudiantes.acquire();
				System.out.println("Estudiante esperando en la cola");
				
				control.cola.add(this);
				
				control.oSemaforoSerranito.release();
				
				
				
				Thread.sleep(5000);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void executeMultiThreading () {
    	
    	List<Serranito> listSerranitos = new ArrayList<Serranito>();
    	List<Estudiante> listEstudiantes = new ArrayList<Estudiante>();
		
		int iContador=0;		
		
		// Creando serranitos
		
		    System.out.println("Creando los platos");
		    for(iContador=0;iContador<5;iContador++) {
		    	listSerranitos.add(new Serranito(iContador));
		    	 control.serranitos.add(listSerranitos.get(iContador));
		    	 new Thread(listSerranitos.get(iContador)).start();
		    }
		  
		   

		// Creando estudiantes
		    for(iContador=0;iContador<10;iContador++) {
		    	listEstudiantes.add(new Estudiante(iContador));
		    	 control.cola.add(listEstudiantes.get(iContador));
		    	 new Thread(listEstudiantes.get(iContador)).start();
		    }
		    
		}

	public static void main(String[] args) {
		try {
			P2 oP2 = new P2();
			oP2.executeMultiThreading();
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

	}
}
