package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Product;

import java.util.List;
public class jpqldemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOFT_PU");
		EntityManager em=emf.createEntityManager();	
		
		Query query1=em.createQuery("select p from Product p");
		
		List<Product> products=query1.getResultList();
		for(Product p:products) {
			System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice());
		}
		
		Query query2=em.createQuery("select p from Product p where p.productName = ?1");
		query2.setParameter(1, "phone12");
		
		Product product=(Product) query2.getSingleResult();
		
		if(product!=null) {
			System.out.println(product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice());
		}
	
		em.close();
		emf.close();

	}

}
