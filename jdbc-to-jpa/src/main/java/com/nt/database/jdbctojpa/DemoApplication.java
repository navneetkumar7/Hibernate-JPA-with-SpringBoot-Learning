package com.nt.database.jdbctojpa;

import com.nt.database.jdbctojpa.jpaHinbernateAdvance.entity.Course;
import com.nt.database.jdbctojpa.jpaHinbernateAdvance.repository.CourseRepository;
import com.nt.database.jdbctojpa.jpaHinbernateAdvance.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
       //logger.info("course find by id {}", courseRepository.findById(10001));
       //courseRepository.save(new Course("microservices learning"));

       //courseRepository.emTracking();
       //courseRepository.emNonTracking();
        //courseRepository.emRefreshMethod();

        //studentRepository.saveStudentWithPassport();
    }
}
