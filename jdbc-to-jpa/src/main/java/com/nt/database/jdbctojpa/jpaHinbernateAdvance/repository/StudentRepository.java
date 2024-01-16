package com.nt.database.jdbctojpa.jpaHinbernateAdvance.repository;

import com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity.Course;
import com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity.Passport;
import com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public void deleteById(int id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("T1289");
        em.persist(passport);

        Student student = new Student("Sumit");
        student.setPassport(passport);

        em.persist(student);
    }

}
