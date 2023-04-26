package br.com.kca.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping("/msg")
	public String listMsg() {
		return "Curso Dev Software";
	}

}
