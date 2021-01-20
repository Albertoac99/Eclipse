package app;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Dbm {

	public static SessionFactory getSessionFactory() {
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		return conf;
	}
	
}
