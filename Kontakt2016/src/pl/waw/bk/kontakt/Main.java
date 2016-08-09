package pl.waw.bk.kontakt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Kontakt");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
