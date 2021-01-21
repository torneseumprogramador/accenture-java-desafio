package com.gama;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gama.model.Usuario;
import com.gama.service.UsuarioService;

@SpringBootApplication
public class AccentureJavaDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccentureJavaDesafioApplication.class, args);
	}
	

	@Bean
    public CommandLineRunner run( UsuarioService bean) {
        return args -> {
           bean.criarContaPadrao();
     
        };
    }

}
