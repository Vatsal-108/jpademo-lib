package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeptEmpSaveMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SOFT_PU");
		EntityManager em=emf.createEntityManager();
		
		Department dept1=new Department();
		dept1.setDeptId(100);
		dept1.setDeptName("IT");
		
		Employee emp1=new Employee();
		emp1.setEmpId(1001);
		emp1.setEmpName("Vatsal");
		emp1.setMobile("98985333116");
		emp1.setSalary(50000);
		emp1.setEmail("vatsal@gmail.com");
		emp1.setDept(dept1);
		
		Employee emp2=new Employee();
		emp2.setEmpId(1002);
		emp2.setEmpName("Vickey");
		emp2.setMobile("98985333110");
		emp2.setSalary(50000);
		emp2.setEmail("vickey@gmail.com");
		emp2.setDept(dept1);
		
		List<Employee> emplist = new ArrayList<>();
		emplist.add(emp1);
		emplist.add(emp2);
		dept1.setEmployees(emplist);
		
		em.getTransaction().begin();
		
		em.persist(emp1);
		em.persist(emp2);
		em.persist(dept1);
		
		
		
		
		System.out.println("Data Saved");
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		
		
		
		
		
	}

}
