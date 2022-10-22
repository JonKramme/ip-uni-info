package dev.JonKramme.ipuniinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class IpUniInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpUniInfoApplication.class, args);
	}

}
