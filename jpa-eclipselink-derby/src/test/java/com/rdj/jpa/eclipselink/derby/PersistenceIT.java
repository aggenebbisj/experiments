package com.rdj.jpa.eclipselink.derby;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.rjd.jpa.eclipselink.derby.domain.Department;
import com.rjd.jpa.eclipselink.derby.domain.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class PersistenceIT {

    private EntityManager manager;

    @Before
    public void before() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("integration-test");
        manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            createEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
    }

    @After
    public void after() {
        // TODO drop tables
        // TODO necessary?
        manager.close();
    }
    
    private void createEmployees() {
        Department department = new Department("java");
        department.addEmployee(new Employee("Jakab Gipsz", department));
        department.addEmployee(new Employee("Captain Nemo", department));
        manager.persist(department);
    }

    @Test
    public void testEmployees() {
        List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
        assertThat(resultList.size(), is(2));
    }

}
