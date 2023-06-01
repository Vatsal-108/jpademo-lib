package com.main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Product;
public class SaveProductDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product=new Product();
		product.setProductId(1100);
		product.setProductName("Samsung1001");
		product.setProductPrice(160000);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOFT_PU");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		System.out.println("Product Saved");
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
