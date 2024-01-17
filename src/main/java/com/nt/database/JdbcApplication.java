package com.nt.database;

import com.nt.database.jdbc.PersonJdbcDAO;
import com.nt.database.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;


//@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonJdbcDAO personJdbcDAO;

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All persons->{}",personJdbcDAO.findAll());
		logger.info("All persons with custom row mapper->{}",personJdbcDAO.findAll());
		logger.info("Persons by id->{}",personJdbcDAO.findById(10001));
		logger.info("Persons by name ->{}",personJdbcDAO.findByName("Shally"));
		logger.info("Delete by id ->{}",personJdbcDAO.deleteById(10002));
		logger.info("Inserting 10005->{}",personJdbcDAO.insert(new Person(10005, "Zelinsky","Berlin",new Date())));
		logger.info("Updating 10003>{}",personJdbcDAO.update(new Person(10003, "Shally","Berlin",new Date())));
	}
}
