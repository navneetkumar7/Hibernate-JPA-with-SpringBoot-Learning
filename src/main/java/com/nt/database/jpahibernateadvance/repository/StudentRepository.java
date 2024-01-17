package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.jpahibernateadvance.entity.Course;
import com.nt.database.jpahibernateadvance.entity.Passport;
import com.nt.database.jpahibernateadvance.entity.Student;
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

    public void insertStudentAndCourse(Student student, Course course){
        student.addCourse(course); // owning side should have the relationship defined then only mapping will be set
        //course.addStudent(student);

        em.persist(student);
        em.persist(course);
    }


}
