package com.your.choice.brigadeservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "BrigadeService API", version = "1.0", description = "BrigadeService information"))
public class BrigadeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrigadeServiceApplication.class, args);
	}
}
