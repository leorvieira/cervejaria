package br.com.fiap.cervejaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CervejariaApplication {

	public static void main(String[] args) {
		System.out.println("passou no main ");
		SpringApplication.run(CervejariaApplication.class, args);
	}



}
