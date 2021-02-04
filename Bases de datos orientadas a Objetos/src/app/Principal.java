package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Alojamiento;
import model.Pared;
import model.Persiana;
import model.Punto;
import model.Suelo;

public class Principal {

	public static void main(String[] args) {
		// Abrimos la conexión con la Base de Datos
		// Creamos una nueva Base de Datos si no existiera aún
		
		EntityManagerFactory conn = Persistence.createEntityManagerFactory("$objectdb/db/alojamiento.odb");
		
		EntityManager session = conn.createEntityManager();
		
		// Almacena 100 objetos Punto en la Base de Datos
		session.getTransaction().begin();
		Pared p = new Pared("gotele", "blanca");
		session.persist(p);
		Suelo s = new Suelo(100);
		session.persist(s);
		Persiana per = new Persiana(20,15,"amarillo");
		session.persist(per);
		Alojamiento alojamiento = new Alojamiento(p,s , per);

		session.persist(alojamiento);
//		for (int i = 0; i < 3; i++) {
//			//Punto p = new Punto(i, i);
//			
//			session.persist(p);
//		}
		session.getTransaction().commit();
		
//		// Obtener el total de objetos Punto en la Base de Datos
//		Query q1 = session.createQuery("SELECT COUNT (p) FROM Punto p");		
//		System.out.println("Total de puntos = "+ q1.getSingleResult());
//		
//		// Obtener el promedio de todas las coordenadas X
//		Query q2 = session.createQuery("SELECT AVG(p.x) FROM Punto p");		
//		System.out.println("Valor promedio de X = "+ q2.getSingleResult());
//		
//		// Recuperar todos los objetos Punto de la Base de Datos
//		TypedQuery<Punto> q3 = session.createQuery("SELECT p FROM Punto p", Punto.class);
//		List<Punto> lstPuntos = q3.getResultList();
//		for(Punto p : lstPuntos) {
//			System.out.println(p);
//		}
		
		
		// Cerramos la conexión con la Base de Datos
		session.close();
		conn.close();
		
		
	}

}
