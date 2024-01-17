package com.nt.database.jpahibernateadvance.repository;

import com.nt.database.DemoApplication;
import com.nt.database.jpahibernateadvance.entity.Passport;
import com.nt.database.jpahibernateadvance.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = DemoApplication.class)
class StudentRepositoryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    public void findByIdTest() {
        Student student = studentRepository.findById(20001); //EAGER Fetching: we are only pulling student but passport is also pulled as it has one to on relation with student
        logger.info("Student name->{}", student.getName());
        //logger.info("Student passport->{}", student.getPassport()); // error in case lazy fetch is set because there is no transaction context.Transaction is getting ended in the first line of the method.
    }

    @Test
    @Transactional
    public void reteriveStudentAndPassportDetailsTest() {
        Student student = em.find(Student.class, 20001);
        logger.info("Student name->{}", student.getName());
        logger.info("Student passport->{}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportAndAssociatedStudentDetailsTest() {
        Passport passport = em.find(Passport.class, 40001);
        logger.info("passport->{}", passport);
        logger.info("Student ->{}", passport.getStudent());
    }

    @Test
    @Transactional
    public void retrieveStudentAndAssociatedCoursesTest() {
        Student student = em.find(Student.class, 20001);
        logger.info("student->{}", student);
        logger.info("Associated courses ->{}", student.getCourses());
    }

    @Test
    @Transactional
    // the moment we create a transaction Persistence Context is build
    public void someTest() {
        //Database operation 1: Retrieve student
        Student student = em.find(Student.class, 20001);
        //Persistence Context(student)

        //Database operation 2: Retrieve passport
        Passport passport = student.getPassport();
        //Persistence Context(student, passport)

        //Database operation 3: update passport
        passport.setNumber("G2389");
        //Persistence Context(student, passport++)

        //Database operation 4: update student
        student.setName("Navneet-updated");
        //Persistence Context(student++, passport++)

    }
}