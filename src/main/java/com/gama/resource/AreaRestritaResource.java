package com.gama.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restrita")
public class AreaRestritaResource {
	@GetMapping
	public String restrita() {
		return "AREA RESTRITA - SUCESSO TOKEN AUTENTICACAO";
	}
}
