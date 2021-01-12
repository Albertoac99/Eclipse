package app;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dbm {

	private static SessionFactory conf = null;
	public static Session session = null;
	private static Transaction tx = null;
	
	private static void openConnection() {
		try {
			
			conf = new Configuration().configure().buildSessionFactory();
			
		}catch(Exception e) {
			System.out.println("Error en el fichero de ocnfiguración." +e.getMessage());
		}
		
	}
	
	
	private static void closeConnection() {
		
		if(conf != null) {
			conf.close();
			
		}
	}
	
	public static void openSession() {
		
		if(conf == null) {
			openConnection();
		}
		if(session == null) {
			session = conf.getCurrentSession();
		}
	}
	
	public static void closeSession() {
		if(session != null && session.isOpen()) {
			session.close();
		}
		
		
		closeConnection();
		
	}
	
	public static void openTransaccion() {
		if(tx != null) {
			tx = Dbm.session.beginTransaction();
		}
	}
	
	public static void commitTransaction() {
		if(tx != null) {
			tx.commit();
		}
	}
	
	
}
