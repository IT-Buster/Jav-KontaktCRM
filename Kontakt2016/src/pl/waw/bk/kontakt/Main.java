package pl.waw.bk.kontakt;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;

import org.metawidget.swing.*;

import model.*;

public class Main {

	public static void main(String[] args) {
		
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Kontakt");
		//EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		Category category = new Category();
		Customer customer = new Customer();
		Role role = new Role();
		
		SwingMetawidget metawidget = new SwingMetawidget();
		metawidget.setToInspect(role);
		
		JFrame frame = new JFrame("Dodawanie Bran¿y");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(metawidget);
		frame.setSize(600, 450);
		frame.setVisible(true);
		
/*		ArrayList<String> singleCategory = new ArrayList<String>();
		singleCategory.add("Sport");
		singleCategory.add("Kultura");
		singleCategory.add("Moda");
		
		//category.setName("Elektronika");
		
		entityManager.getTransaction().begin();

        for (String s : singleCategory) {
        	Category category = new Category();
        	category.setName(s);
        	
        	entityManager.persist(category);
        	entityManager.flush();
        	entityManager.clear();
        }*/
		
		
		//entityManager.persist(category); 
	//	entityManager.getTransaction().commit();
		
	//	entityManager.close();
	//	entityManagerFactory.close();	
		
		
	}

}
