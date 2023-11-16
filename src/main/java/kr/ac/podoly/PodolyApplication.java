package kr.ac.podoly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PodolyApplication {

	public static void main(String[] args) {

		SpringApplication.run(PodolyApplication.class, args);
	}

}
