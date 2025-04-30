package br.edu.xpe.onlinesales.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RootController {

	@GetMapping("/")
	public String root() {
		return "<h1>Bootcamp | Arquiteto de Software | XPE</h1><h2>Desafio Final</h2><h2>Aluno: Pedro Victor Costa Nascimento </h2>";
	}

}
