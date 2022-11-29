package com.sample.demo.jpa;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.sample.demo.jpa.entity.Student;
import com.sample.demo.jpa.util.JPAUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    		Scanner sc = new Scanner(System.in);
    		
    		EntityManager entityManager = JPAUtil.buildEntityManagerFactory().createEntityManager();
    		entityManager.getTransaction().begin();
            System.out.println("1. Add a Student");
            System.out.println("2. List All Students");
            System.out.println("3. Edit Student details");
            System.out.println("4. Delete a Student");
            System.out.println("5. Exit");
            System.out.print("Your Choice? ");
            int ch = sc.nextInt();
            
            
            switch(ch) {
            case 1: 
            	System.out.println("Enter Student Firstname: ");
                String fName = sc.next();
                
                System.out.println("Enter Student Lastname: ");
                String lName = sc.next();
                
                System.out.println("Enter Student Email: ");
                String email = sc.next();
//            	
            	Student student = new Student(fName, lName, email);
            	
            	entityManager.persist(student);
            	entityManager.getTransaction().commit();
            	entityManager.close();
            case 2:
            	@SuppressWarnings("unchecked")
            	List<Student> list = entityManager.createQuery("from Student").getResultList();
            	
            	for(Student s: list) {
            		System.out.println(s.toString());
            	}
            	entityManager.getTransaction().commit();
            case 3:
            	System.out.println("Enter id to be updated: ");
            	int id = sc.nextInt();
            	System.out.println("Enter Student Firstname: ");
                String firstName = sc.next();
                System.out.println("Enter Student Lastname: ");
                String lastName = sc.next();               
                System.out.println("Enter Student Email: ");
                String emailId = sc.next();
                
                Student s = entityManager.find(Student.class, id);
                s.setFirstName(firstName);
                s.setLastName(lastName);
                s.setEmail(emailId);
                System.out.println(s.toString());
                entityManager.getTransaction().commit();
                entityManager.close();
            	
            	JPAUtil.shutDown();
                break;
            case 4:
            	Student ss = new Student();
            	System.out.println("Enter ID to be deleted: ");
            	int Id = sc.nextInt();
            	ss.setId(Id);
            	entityManager.remove(ss);
            	System.out.println("student is deleted");
            	entityManager.getTransaction().commit();
            	entityManager.close();
            	break;
 	}
    }
}  
