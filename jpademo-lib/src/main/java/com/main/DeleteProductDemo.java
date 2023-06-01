package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Product;

public class DeleteProductDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SOFT_PU");
		EntityManager em=emf.createEntityManager();
		int productId=1;
		Product product=em.find(Product.class, productId);
		
		if(product!=null) {
			em.getTransaction().begin();
			
			em.remove(product);
			
			System.out.println("Product Deleted");
			
			em.getTransaction().commit();
		}
		else {
			
		}
		em.close();
		emf.close();
	}

}
