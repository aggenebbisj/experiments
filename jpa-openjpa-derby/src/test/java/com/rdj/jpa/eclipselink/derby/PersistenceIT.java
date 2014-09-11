package com.rdj.jpa.eclipselink.derby;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.rjd.jpa.eclipselink.derby.domain.bidirectional.Department;
import com.rjd.jpa.eclipselink.derby.domain.bidirectional.Employee;
import com.rjd.jpa.eclipselink.derby.domain.unidirectional.Car;
import com.rjd.jpa.eclipselink.derby.domain.unidirectional.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

public class PersistenceIT {

    private EntityManager em;

    @Before
    public void before() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("integration-test");
        em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
//            setupBidirectional();
//            setupUnidirectional();
//              setupTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
    }

    @After
    public void after() {
        // TODO drop tables
        // TODO necessary?
        em.close();
    }
    
    private void setupBidirectional() {
        Department department = new Department("Java");
        department.addEmployee(new Employee("Jakab Gipsz", department));
        department.addEmployee(new Employee("Captain Nemo", department));
        em.persist(department);
    }

    private void setupUnidirectional() {
        Person remko = new Person("Remko");
        remko.addCar(new Car("Maserati"));
        em.persist(remko);
    }
    
    private void setupTest() {
        Person p = new Person("Sjaak");
        p.addCar(new Car("Opel"));
        em.persist(p);
    }
    
    @Ignore
    @Test
    public void testEmployees() {
        List<Employee> resultList = em.createQuery("Select a From Employee a", Employee.class).getResultList();
        assertThat(resultList.size(), is(2));
    }

    @Test
    public void test_replace_collection_with_bidirectional_relation() {
        em.getTransaction().begin();
        Department d = em.find(Department.class, 1L);
        
        final ArrayList<Employee> employees = new ArrayList<Employee>();
        d.addEmployee(new Employee("Sjaak de Vries", d));
        d.addEmployee(new Employee("Henk de Mol", d));
        
        d.setEmployees(employees);
        
        em.flush();
        em.getTransaction().commit();
    }
    
    /**
     * This test will fail because JPA does an update before inserting the new records. 
     * The update will set the foreign key to null, which violates the not null constraint.
     */
    @Test
    public void test_replace_collection_with_unidirectional_relation() {
        em.getTransaction().begin();
        Person p = em.find(Person.class, 201L);
        
        final ArrayList<Car> cars = new ArrayList<Car>();
        p.addCar(new Car("Ferrari"));
        
        p.setCars(cars);
        
        em.flush();
        em.getTransaction().commit();
    }

}
