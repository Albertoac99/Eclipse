package app;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import model.Coche;

public class Logic {

	public static void insertCoche(Coche c) {
		
		Dbm.session.beginTransaction();
		Dbm.session.save(c);
		Dbm.session.getTransaction();
		
	}

	public static Coche getCoche(int id) {
		Dbm.session.beginTransaction();
		Coche c = Dbm.session.get(Coche.class, id); 
		Dbm.session.getTransaction();
		return c;
	}

	public static void update(Coche c) {
		Dbm.session.beginTransaction();
		Dbm.session.update(c); 
		Dbm.session.getTransaction();
	}

	public static void deleteCoche(Coche c) {
		Transaction tx = Dbm.session.beginTransaction();
		Dbm.session.delete(c);
		tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	public static List<Coche> getListAll() {
		List<Coche> lst = new ArrayList<Coche>();
		Dbm.session.beginTransaction();
		lst = Dbm.session.createQuery("from Coche").getResultList();
		return lst;
	}

	public static Coche getCocheMatricula(String strMatricula) {
		Coche c;
		Dbm.session.beginTransaction();
		String query = "FROM COCHE WHERE MATRICULA = '" + strMatricula + "'";
		c = (Coche) Dbm.session.createQuery(query).uniqueResult();
		return c;
	}
}
