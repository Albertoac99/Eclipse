import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class P3 {
	
	public class Control{
		
		//Aclaración:
		//Papel=1 , tabaco = 2, cerilla = 3;
		//si tienes una de cada sumas 6, tambien si tienes tres de tabaco pero está prevista esa posibilidad en el if
		
		private int material1 = random();
		private int material2 = random();
		Queue<Estudiante> estudiantes = new LinkedList<Estudiante>();
		Semaphore oSemaforo = new Semaphore(1);
		Semaphore oSemaphoreEstudiantes  = new Semaphore(0);
		
		
	}
	
	final Control control = new Control();
	
	public class Estudiante implements Runnable{
		
		private int id;
		private int material;
		private int cigarrosFumados;

		public Estudiante(int id,int material,int cigarrosFumados) {
			this.material = material;
			this.cigarrosFumados = cigarrosFumados;
			this.id = id;
			
		}
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getMaterial() {
			return material;
		}

		public void setMaterial(int material) {
			this.material = material;
		}
		
		public int getCigarrosFumados() {
			return cigarrosFumados;
		}

		public void setCigarrosFumados(int cigarrosFumados) {
			this.cigarrosFumados = cigarrosFumados;
		}

		@Override
		public void run() {
			
			try {
				control.estudiantes.add(this);
				while(this.getCigarrosFumados()<10) {
					
				control.oSemaforo.acquire();
				System.out.println("El estudiante "+this.getId()+" se dispone a fumar");
				
				if(this.getMaterial()+control.material1+control.material2==6 && this.getMaterial()!=control.material1) {
					System.out.println("El estudiante "+this.getId()+" se está fumando un cigarro");
					Thread.sleep(1000);
					control.oSemaphoreEstudiantes.release();
					this.setCigarrosFumados(getCigarrosFumados()+1);
				}
				
				
				
				control.oSemaforo.release();
				
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
	public class Reponedor implements Runnable{

		@Override
		public void run() {
			
			try {
				
				
				while(control.estudiantes.size()>0) {
					
					control.oSemaphoreEstudiantes.acquire();
					
					System.out.println("Dependiente reponiendo materiales...");
					control.material1 = random();
					control.material2 = random();
					
				}
				
				
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
	
	private int random() {
		
		
		return (int) (Math.random()*3+1);
	}
	
	
	private void executeMultiThreading() throws InterruptedException {
		
		new Thread(new Reponedor()).start();
		
		for(int iContador=0;iContador<10;iContador++) {
			
			new Thread(new Estudiante(iContador,random(),0)).start();
			Thread.sleep(500);
			
		}
		
		
	}

	public static void main(String[] args) {
		P3 oP3 = new P3();
		try {
			oP3.executeMultiThreading();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
