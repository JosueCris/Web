package com.example.PruebaSpring;

import com.example.PruebaSpring.Models.Persona;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class PruebaSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
	}
}
