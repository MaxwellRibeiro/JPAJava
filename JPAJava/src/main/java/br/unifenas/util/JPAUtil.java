package br.unifenas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String persistence = "PERSISTENCE";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistence);;
	
	public static EntityManager getEntityMananger() {
		return factory.createEntityManager();
	}
	
	public static void close() {
		factory.close();
	}
}
