package app;

public class Start {

	public static void main(String[] args) {
		
		Dbm.openSession();
		
		if(Dbm.session != null) {
			
//			Gest.insert();
//			Gest.update();
//			Gest.delete();
//			Gest.get();
//			Gest.listAll();
			
			Dbm.closeSession();
			
			System.out.println("Todo OK");
		}
		
		else {
			
			System.out.println("No se ha podido establecer la conexión.");
			
		}

	}

}
