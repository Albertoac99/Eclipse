package app;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Dbm {

	public static SessionFactory getSessionFactoryXML() {
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		return conf;
	}
	
	public static SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		
			// --CONFIGURACION-- //
		
			Properties p = new Properties();
			
			p.put(Environment.URL, "jdbc:mysql://localhost/medac");
			p.put(Environment.USER, "root");
			p.put(Environment.PASS, "");
			
			p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			p.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			
			p.put(Environment.SHOW_SQL, "true");
			p.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			
			conf.setProperties(p);
			
			// --MAPPING-- //
			
			conf.addAnnotatedClass(model.Coche.class);
			
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			
		
		return conf.buildSessionFactory(sr);
	}
	
}
