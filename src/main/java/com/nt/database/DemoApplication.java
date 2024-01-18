package com.nt.database;

import com.nt.database.jpahibernateadvance.entity.*;
import com.nt.database.jpahibernateadvance.repository.CourseRepository;
import com.nt.database.jpahibernateadvance.repository.EmployeeRepository;
import com.nt.database.jpahibernateadvance.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //logger.info("course find by id {}", courseRepository.findById(10001));
        //courseRepository.save(new Course("microservices learning"));

        //courseRepository.emTracking();
        //courseRepository.emNonTracking();
        // courseRepository.emRefreshMethod();
        // studentRepository.saveStudentWithPassport();
        //courseRepository.addReviewsForCourse(10003, getReviews());
        //studentRepository.insertStudentAndCourse(new Student("Rakshit"), new Course("Salsa learning"));
        //courseRepository.getCourseAndStudent(1);
        //employeeRepository.insertEmployee(new FullTimeEmployee("Rohan", new BigDecimal(10000)));
        //employeeRepository.insertEmployee(new PartTimeEmployee("Monica", new BigDecimal(50)));
        //logger.info("All employees-> {}", employeeRepository.retrieveAllEmployees());
        //logger.info("Full time employees-> {}", employeeRepository.retrieveFullTimeEmployee());
    }

    private static List<Review> getReviews() {
        Review review1 = new Review("4", "helpful course!");
        Review review2 = new Review("5", "Awesome course!");
        return List.of(review1, review2);
    }
}
