package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Product;

public class FindProductDemo {

	public static void main(String[] args) {
		
		int productId=1001;
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOFT_PU");
		EntityManager em=emf.createEntityManager();	
		
		
		Product product=em.find(Product.class, productId);
		if(product!=null) {
			System.out.println("Product Name: "+product.getProductName());
			System.out.println("Product Price: "+product.getProductPrice());
		}
		else {
			System.out.println("Product not existing with ID "+productId);
		}
		em.close();
		emf.close();
	}

}
