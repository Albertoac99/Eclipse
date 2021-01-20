package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Coche;

public class Logic {

	public static Coche getCoche(int id) {
		Coche c = null;

		Transaction transaction = null;
		try (Session session = Dbm.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			c = session.get(Coche.class, id);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
		}

		return c;
	}

	public static boolean saveCoche(Coche c) {
		boolean finishOK;
		Transaction transaction = null;
		try (Session session = Dbm.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.save(c);

			transaction.commit();
			finishOK = true;
		} catch (Exception e) {
			finishOK = false;
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
		}

		return finishOK;
	}

	public static boolean saveOrUpdate(Coche c) {
		boolean finishOK;
		Transaction transaction = null;
		try (Session session = Dbm.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.saveOrUpdate(c);

			transaction.commit();
			finishOK = true;
		} catch (Exception e) {
			finishOK = false;
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
		}

		return finishOK;
	}

	public static boolean delete(Coche c) {
		boolean finishOK;
		Transaction transaction = null;
		try (Session session = Dbm.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			session.delete(c);

			transaction.commit();
			finishOK = true;
		} catch (Exception e) {
			finishOK = false;
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
		}

		return finishOK;
	}

	@SuppressWarnings("unchecked")
	public static List<Coche> getAllCoches() {
		List<Coche> lstCoches = null;
		Transaction transaction = null;
		
		try (Session session = Dbm.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			lstCoches = session.createQuery("from Coche").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.err.println(e.getMessage());
		}

		return lstCoches;
	}

}
