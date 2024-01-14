package com.nt.database.jdbctojpa.jpa;

import com.nt.database.jdbctojpa.jpa.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {
    //connect to the database
    @PersistenceContext // all the operation are stored in it
    EntityManager entityManager; // EM is interface to PersistenceContext, all ops have to go through EM.
    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }
    public List<Person> findAll(){
       TypedQuery<Person> namedQuery= entityManager.createNamedQuery("find_all_persons", Person.class);
       return namedQuery.getResultList();

    }
    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person=findById(id);
         entityManager.remove(person);
    }
}
