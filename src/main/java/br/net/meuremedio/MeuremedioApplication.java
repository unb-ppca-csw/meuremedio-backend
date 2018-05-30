package br.net.meuremedio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("br.net.meuremedio.repository")
public class MeuremedioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuremedioApplication.class, args);
	}

}
