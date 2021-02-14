import java.util.concurrent.Semaphore;

public class Filosofos {

	private final int ESTUDIANTES = 5;
	private final int PALILLOS = 5;

	public class Control {

		private Semaphore[] sPalillos = new Semaphore[PALILLOS];

		public Control() {
			for (int i = 0; i < PALILLOS; i++)
				sPalillos[i] = new Semaphore(1);
		}

		public Semaphore[] getsPalillos() {
			return sPalillos;
		}

		public void setsPalillos(Semaphore[] sPalillos) {
			this.sPalillos = sPalillos;
		}
	}

	private Control control = new Control();

	public class Filosofo implements Runnable {
		private int iId;
		private int iDer;
		private int iIzq;

		public Filosofo(int iId) {
			this.iId = iId;
		}

		public int getiId() {
			return iId;
		}

		public void setiId(int iId) {
			this.iId = iId;
		}
	
		public boolean cogerPalillos() {
			boolean bExito = false;

			iIzq = getiId();
			
			iIzq = getiId();
			
			if (iIzq == 4)
				iDer = 0;
			else
				iDer = iIzq + 1;

			if (control.sPalillos[iIzq].availablePermits() > 0 && control.sPalillos[iDer].availablePermits() > 0) {
				bExito = true;
				try {
					control.sPalillos[iIzq].acquire();
					control.sPalillos[iDer].acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return bExito;
		}

		public boolean soltarPalillos() {
			boolean bExito = false;

			if (control.sPalillos[iIzq].availablePermits() == 0 && control.sPalillos[iDer].availablePermits() == 0) {
				bExito = true;
				control.sPalillos[iIzq].release();
				control.sPalillos[iDer].release();
			}
			return bExito;
		}

		@Override
		public synchronized void run() {
			System.out.println("El filósofo " + getiId() + " está listo para comer");

			while (true) {

				if (cogerPalillos()) {
					System.out.println(
							"El filósofo " + getiId() + " coge los palilos " + iIzq + " y " + iDer + ", para comer");
					try {
						Thread.sleep(2000);

						System.out.println("El filósofo " + getiId() + " acaba de comer y descansa");
						System.out.println("Palillos " + iIzq + " y " + iDer + " libres");

						soltarPalillos();

						Thread.sleep(6000);

						System.out.println("El filósofo " + getiId() + " vuelve a estar listo para comer");

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void executeMultiThreading() throws InterruptedException {

		for (int i = 0; i < ESTUDIANTES; i++)
			new Thread(new Filosofo(i)).start();
	}

	public static void main(String[] args) {
		try {
			Filosofos filosofos = new Filosofos();
			filosofos.executeMultiThreading();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
