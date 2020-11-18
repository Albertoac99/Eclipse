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
			
			try {
				
				control.oSemaforoPlato.acquire();
				control.oSemaforoClientes.acquire();
				
				
				
				
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
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
		  
		   

		// Creando clientes
		while(true) {
			
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
