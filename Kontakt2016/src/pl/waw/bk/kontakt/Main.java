package pl.waw.bk.kontakt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.*;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Kontakt");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		Category category = new Category();
		category.setName("Dom"); 
		
		entityManager.getTransaction().begin();
		entityManager.persist(category); 
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
