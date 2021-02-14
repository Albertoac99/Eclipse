import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Principal {

	public class Control {

		public int iNumEstudiantes = 5;
		public int iNumSerranitos = 3;

		private Semaphore oSemEstudiantes = new Semaphore(iNumEstudiantes);
		private Semaphore oSemSerranitos = new Semaphore(iNumSerranitos);
		private Semaphore oSemCocinero = new Semaphore(0);

		public Semaphore getoSemEstudiantes() {
			return oSemEstudiantes;
		}

		public void setoSemEstudiantes(Semaphore oSemEstudiantes) {
			this.oSemEstudiantes = oSemEstudiantes;
		}

		private Queue<Integer> cola = new LinkedList<Integer>();

		public Semaphore getoSemSerranitos() {
			return oSemSerranitos;
		}

		public void setoSemSerranitos(Semaphore oSemSerranitos) {
			this.oSemSerranitos = oSemSerranitos;
		}
	}

	final Control control = new Control();

	// -------------------------------------------------------------------------------------------------------------------------------------

	public class Cocinero implements Runnable {

		private int iId;

		public Cocinero(int iId) {
			setiId(iId);

		}

		public int getiId() {
			return iId;
		}

		public void setiId(int iId) {
			this.iId = iId;
		}

		@Override
		public synchronized void run() {
			while (true) {
				try {

					control.oSemCocinero.acquire();

					System.out.println("El cocinero recarga el armario...");
					control.oSemSerranitos.release(control.iNumSerranitos);
					control.oSemEstudiantes.release(control.iNumEstudiantes);

				} catch (Exception e) {
					System.out.println("Error en el run del cocinero: " + e.getMessage());
				}
			}
		}
	}

	// -------------------------------------------------------------------------------------------------------------------------------------

	public class Estudiantes implements Runnable {

		private int iId;
		private byte bTiempo;

		public Estudiantes(int iId) {
			setiId(iId);
			setbTiempo((byte) ((Math.random() * 5) + 1));
		}

		public int getiId() {
			return iId;
		}

		public void setiId(int iId) {
			this.iId = iId;
		}

		public byte getbTiempo() {
			return bTiempo;
		}

		public void setbTiempo(byte bTiempo) {
			this.bTiempo = bTiempo;
		}

		@Override
		public void run() {

			int iId;

			while (true) {
				try {

					control.oSemEstudiantes.acquire();
					System.out.println("Estudiante " + getiId() + " llegando al Mercadona...");
					Thread.sleep(((byte) ((Math.random() * 5) + 1)));

					control.cola.add(getiId());

					if (control.oSemSerranitos.hasQueuedThreads()) {

						System.out.println("El estudiante " + getiId() + " llama al cocinero.");
						control.oSemCocinero.release();
						control.oSemEstudiantes.acquire(control.iNumEstudiantes);
					}

					iId = control.cola.poll();

					System.out.println("Estudiante " + iId + " coge un serranito.");

					// Restamos un serranito del armario
					control.oSemSerranitos.acquire();

					// Este estudiante no puede coger otro serranito hasta dentro de 10 seg
					System.out.println("Estudiante " + iId + " se va.");
					Thread.sleep(10000);
					control.oSemEstudiantes.release();

				} catch (Exception e) {
					System.out.println("Error en el run de Estudiantes: " + e.getMessage());
				}
			}
		}
	}

	// -------------------------------------------------------------------------------------------------------------------------------------

	private void executeMultiThreading() throws InterruptedException {

		int iNumEstudiantes = control.iNumEstudiantes;

		for (int iCont = 0; iCont < iNumEstudiantes; iCont++) {
			new Thread(new Estudiantes(iCont)).start();
			Thread.sleep(1000);
		}

		// ------------------------------------------------------------------------------------------------

		// Inicimos el hilo cocinero
		new Thread(new Cocinero(0)).start();

	}

	// -------------------------------------------------------------------------------------------------------------------------------------

	public static void main(String[] args) {

		try {
			Principal principal = new Principal();
			principal.executeMultiThreading();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
