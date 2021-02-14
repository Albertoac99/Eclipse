import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;


public class EJ1 {

	public class Control{
		
		Semaphore oSemaforoPlato = new Semaphore(5);
    	Semaphore oSemaforoClientes = new Semaphore(0);
    	Queue<Cliente> cola = new LinkedList<Cliente>();
    	Queue<Plato> platos = new LinkedList<Plato>();
    	
		public Semaphore getoSemaforoPlato() {
			return oSemaforoPlato;
		}
		public void setoSemaforoPlato(Semaphore oSemaforoPlato) {
			this.oSemaforoPlato = oSemaforoPlato;
		}
		public Semaphore getoSemaforoClientes() {
			return oSemaforoClientes;
		}
		public void setoSemaforoClientes(Semaphore oSemaforoClientes) {
			this.oSemaforoClientes = oSemaforoClientes;
		}
		
    	
	}
	
	final Control control = new Control();
	
	public class Plato implements Runnable{
		
		private int iID;

		public Plato(int iID) {
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
				
				control.oSemaforoPlato.acquire();
				control.oSemaforoClientes.acquire();
				
				int numero = control.cola.poll().getiID();
				int numeroplato =control.platos.poll().getiID();
				System.out.println("El cliente numero "+numero+" ha cogido el plato "+numeroplato);
				System.out.println(control.platos.size());
				if(control.platos.size()==0) {
					for(int iContador=0;iContador<5;iContador++) {
						control.platos.add(new Plato(iContador));
						control.oSemaforoPlato.release();
					}
					
					System.out.println("El cocinero ha repuesto todos los platos");
					
				}
				else {
					control.oSemaforoPlato.release();
				}
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		}		
		
	}
	
	
	public class Cliente implements Runnable{

		private int iID;
		
		public Cliente(int iID) {
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
			
				
				System.out.println("Cliente esperando en la cola");
				
				control.cola.add(this);
				
				control.oSemaforoClientes.release();
				
				
			
			
		}
		
	}
	
	private void executeMultiThreading () {
    	
    	List<Plato> listPlatos = new ArrayList<Plato>();
    	
		
		int iContador=0;		
		
		// Creando platos
		
		    System.out.println("Creando los platos");
		    for(iContador=0;iContador<5;iContador++) {
		    	 listPlatos.add(new Plato(iContador));
		    	 control.platos.add(listPlatos.get(iContador));
		    	 new Thread(listPlatos.get(iContador)).start();
		    }
		  
		 iContador=0;

		// Creando clientes
		while(true) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente a punto de pedir");
		new Thread(new Cliente(iContador)).start();
				
		iContador++;
			
			
	
		}
		    
		}

	public static void main(String[] args) {
		try {
			EJ1 oEJ1 = new EJ1();
			oEJ1.executeMultiThreading();
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}

	}

}
