package app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Coche;

public class Principal {

	public static void main(String[] args) {
		
		SessionFactory conf = new Configuration().configure("hibernate.cfg.Oracle.xml").buildSessionFactory();
		
		
			Session session = conf.getCurrentSession();
		
			Coche c = new Coche(1500, "Audi", "A3");
		
			Transaction tx = session.beginTransaction();
			session.save(c);
			tx.commit();
		
		
			session.close();
			
		conf.close();
		
		System.out.println("Almacenado "+c.toString());
	}

}
