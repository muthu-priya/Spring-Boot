package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository repository) {
		return (args) -> {
			// save a few Students
			repository.save(new Student("Jack", "aaa@mail.com",11122));
			repository.save(new Student("Chloe", "bbb@mail.com",22233));
			repository.save(new Student("Kim", "ccc@mail.com",33344));
			repository.save(new Student("David", "ddd@mail.com",44455));
			repository.save(new Student("Michelle", "eee@mail.com",55566));

			// fetch all Students
			log.info("Students found with findAll():");
			log.info("-------------------------------");
			for (Student student : repository.findAll()) {
				log.info(student.toString());
			}
			log.info("");

			// fetch an individual student by ID
			Student student = repository.findById(1L);
			log.info("Student found with findById(1L):");
			log.info("--------------------------------");
			log.info(student.toString());
			log.info("");

			// fetch students by last name
			log.info("Student found with findByfirstName(Jack):");
			log.info("--------------------------------------------");
			repository.findByfirstName("Jack").forEach(Jack -> {
				log.info(Jack.toString());
			});
			log.info("");

			//fetch students By PhoneNum
			log.info("Student found with findByphoneNum(22233):");
			log.info("--------------------------------------------");
			repository.findByphoneNum(22233).forEach(phoneNum -> {
				log.info(phoneNum.toString());
			});
			log.info("");

			//fetch students By Email
			log.info("Student found with findByEmail(ddd@mail.com):");
			log.info("--------------------------------------------");
			repository.findByEmail("ddd@mail.com").forEach(x -> {
				log.info(x.toString());
			});
			log.info("");

		};
	}

}
