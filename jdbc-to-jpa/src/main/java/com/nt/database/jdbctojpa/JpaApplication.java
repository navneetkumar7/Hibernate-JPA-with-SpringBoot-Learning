package com.nt.database.jdbctojpa;


import com.nt.database.jdbctojpa.jpa.entity.Person;
import com.nt.database.jdbctojpa.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All persons->{}",personJpaRepository.findById(10001));
		logger.info("Inserting 10005->{}",personJpaRepository.insert(new Person( "Zelinsky","Berlin",new Date())));
		logger.info("Updating 10003>{}",personJpaRepository.update(new Person(10003, "Shally","Germany",new Date())));
		personJpaRepository.deleteById(10002);
		logger.info("All persons with custom row mapper->{}",personJpaRepository.findAll());
		/*
		logger.info("Persons by id->{}",personJdbcDAO.findById(10001));
		logger.info("Persons by name ->{}",personJdbcDAO.findByName("Shally"));


	*/}
}
