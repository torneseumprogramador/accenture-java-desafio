package com.gama.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gama.dto.LancamentoDto;
import com.gama.model.PlanoConta;
import com.gama.repository.PlanoContaRepository;
import com.gama.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class DashboardResource {
	@Autowired
	private LancamentoService service;
	
	@Autowired
	private PlanoContaRepository planoContaRepositoy;
	
	
	@PostMapping()
	public void post(@RequestBody LancamentoDto body) throws Exception {
		service.confirmar(body);
	}
	
	@PostMapping("/planos-conta")
	public void post(@RequestBody PlanoConta body) throws Exception {
		planoContaRepositoy.save(body);
	}
	

	@GetMapping("/planos-conta")
	public List<PlanoConta> getPlanosConta(@RequestParam("login") String login) throws Exception {
		return planoContaRepositoy.findByLogin(login);
	}
}
