import java.util.concurrent.Semaphore;

public class EJ3 {
	
	public class Control{
		private final int NUM_ESTUDIANTES = 4;
		private final int NUM_PORCIONES = 6;
		private int porcionesActuales = NUM_PORCIONES;
		Semaphore oSemaphoreBilios = new Semaphore(0);
		Semaphore oSemaphoreEstudiantes = new Semaphore(1);
		Semaphore oSemaphorePizzas = new Semaphore(NUM_PORCIONES);
		
		
		public int getPorcionesActuales() {
			return porcionesActuales;
		}
		public void setPorcionesActuales(int porcionesActuales) {
			this.porcionesActuales = porcionesActuales;
		}
		public Semaphore getoSemaphoreBilios() {
			return oSemaphoreBilios;
		}
		public void setoSemaphoreBilios(Semaphore oSemaphoreBilios) {
			this.oSemaphoreBilios = oSemaphoreBilios;
		}
		public Semaphore getoSemaphoreEstudiantes() {
			return oSemaphoreEstudiantes;
		}
		public void setoSemaphoreEstudiantes(Semaphore oSemaphoreEstudiantes) {
			this.oSemaphoreEstudiantes = oSemaphoreEstudiantes;
		}
		public Semaphore getoSemaphorePizzas() {
			return oSemaphorePizzas;
		}
		public void setoSemaphorePizzas(Semaphore oSemaphorePizzas) {
			this.oSemaphorePizzas = oSemaphorePizzas;
		}
		
		
	}
	
	final Control control = new Control();
	
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
			
				Thread.sleep((long) ((Math.random()*5+1)*1000));
			
				control.oSemaphoreEstudiantes.acquire();
	
			System.out.println("El estudiante "+this.getiID()+ " quiere coger una porcion");
			
			if(control.porcionesActuales==0) {
				
				System.out.println("El estudiante "+this.getiID()+" pide una nueva pizza");
				control.oSemaphoreBilios.release();
			
			}
			
			control.oSemaphorePizzas.acquire();
			control.porcionesActuales--;

			System.out.println("El estudiante "+this.getiID()+ " ha cogido una porcion y se dispone a estudiar");
			
			control.oSemaphoreEstudiantes.release();
			
			Thread.sleep(8000);
			
			System.out.println("El estudiante "+this.getiID()+" ha terminado de estudiar");
			
			
			
			
		}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
		
	}
	
	public class Bilios implements Runnable{
		
		
		
		

		@Override
		public void run() {
			try {
			while(true) {
				
				control.oSemaphoreBilios.acquire();
				
					System.out.println("El restaurante Bilios prepara una nueva pizza");
					Thread.sleep(3000);
					System.out.println("La pizza está lista");
					control.oSemaphorePizzas.release(control.NUM_PORCIONES);
					control.setPorcionesActuales(control.NUM_PORCIONES);
				
			}
			
			} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
		
		
	}
	
	private void executeMultiThreading() {
		
		new Thread(new Bilios()).start();
		
		for(int iContador=0;iContador<control.NUM_ESTUDIANTES;iContador++) {
			
			new Thread(new Estudiante(iContador)).start();
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
	
		EJ3 oEJ3 = new EJ3();
		
		oEJ3.executeMultiThreading();

	}

}
