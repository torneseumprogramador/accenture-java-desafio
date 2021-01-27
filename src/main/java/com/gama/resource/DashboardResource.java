package com.gama.resource;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gama.dto.Dashboard;
import com.gama.service.DashboardService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/dashboard")
public class DashboardResource {
	@Autowired
	private DashboardService service;
	//https://github.com/swagger-api/swagger-core/wiki/Annotations
	@GetMapping("")
	public Dashboard dashboard(
			@ApiParam(value = "login", example = "master", required = true) @RequestParam("login") String login, 
			@ApiParam(value = "Data Inicio", example = "2021-01-01", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("inicio") LocalDate inicio, 
			@ApiParam(value = "Data Fim", example = "2021-01-31", required = true)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("fim") LocalDate fim ) throws Exception {
		return service.atualizarDashboard(login, inicio, fim);
	}
}
