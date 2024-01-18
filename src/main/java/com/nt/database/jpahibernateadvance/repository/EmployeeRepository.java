package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.jpahibernateadvance.entity.Course;
import com.nt.database.jpahibernateadvance.entity.Employee;
import com.nt.database.jpahibernateadvance.entity.FullTimeEmployee;
import com.nt.database.jpahibernateadvance.entity.Review;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager em;

    public void insertEmployee(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("Select e from Employee e", Employee.class).getResultList();
    }

    // this is for the case when we Employee as MappedSuperClass not as Entity
    public List<FullTimeEmployee> retrieveFullTimeEmployee() {
        return em.createQuery("select fte from FullTimeEmployee fte").getResultList();
    }
}
