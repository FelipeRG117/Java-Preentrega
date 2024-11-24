package com.coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PreentregaFelipeReyesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreentregaFelipeReyesApplication.class, args);
	}
	@Bean //este es el fetch
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}






