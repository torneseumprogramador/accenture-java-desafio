package com.gama;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gama.config.StartConfig;

@SpringBootApplication
public class AccentureJavaDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccentureJavaDesafioApplication.class, args);
	}
	

	@Bean
    public CommandLineRunner run( StartConfig bean) {
        return args -> {
           bean.start();
     
        };
    }

}
