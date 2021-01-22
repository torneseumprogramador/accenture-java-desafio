package com.gama.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.repository.ContaRepository;

@Service
public class LancamentoService {
	@Autowired
	private ContaRepository contaRepository;
	
}
