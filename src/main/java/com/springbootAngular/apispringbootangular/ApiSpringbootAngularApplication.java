package com.springbootAngular.apispringbootangular;

import com.springbootAngular.apispringbootangular.entity.Contact;
import com.springbootAngular.apispringbootangular.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiSpringbootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringbootAngularApplication.class, args);
	}


	//Esto es para agregar personas por defecto al iniciar la api
	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Carlos","carlos@gmail.com", LocalDateTime.now()),
					new Contact("Luis","luis@gmail.com", LocalDateTime.now()),
					new Contact("Jorge","jorge@gmail.com", LocalDateTime.now()),
					new Contact("Felipe","felipe@gmail.com", LocalDateTime.now()),
					new Contact("Pedro","pedro@gmail.com", LocalDateTime.now())
			);
			contactRepository.saveAll(contacts);
		};
	}
}
