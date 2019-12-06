package fr.adaming.formation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetZooApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjetZooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=====Serveur opérationnel=====");
		
	}

}
