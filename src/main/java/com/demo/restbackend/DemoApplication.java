package com.demo.restbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		//contactRepository.save(new Contact("nom01", "prenom01", dateFormat.parse("01/12/1999"), "email01@mail.com", 2201, "photo01"));
		//contactRepository.save(new Contact("nom02", "prenom02", dateFormat.parse("02/12/1999"), "email02@mail.com", 2202, "photo02"));
		//contactRepository.save(new Contact("nom03", "prenom03", dateFormat.parse("03/12/1999"), "email03@mail.com", 2203, "photo03"));
	}

}
