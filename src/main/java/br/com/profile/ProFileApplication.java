package br.com.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.com.profile.repository")
public class ProFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProFileApplication.class, args);
	}

}
