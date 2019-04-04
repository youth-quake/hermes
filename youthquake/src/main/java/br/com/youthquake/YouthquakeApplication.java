package br.com.youthquake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Configuration
public class YouthquakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouthquakeApplication.class, args);
	}
}