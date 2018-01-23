package br.com.rianperassoli.financas.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final String DATABASE_NAME = "financas";
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATABASE_NAME);
	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
