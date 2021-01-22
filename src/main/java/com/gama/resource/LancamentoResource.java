package com.gama.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.dto.LancamentoDto;
import com.gama.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	@Autowired
	private LancamentoService service;
	
	@PostMapping()
	public void post(@RequestBody LancamentoDto body) throws Exception {
		service.confirmar(body);
	}
}
