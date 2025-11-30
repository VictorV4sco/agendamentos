package com.agendamentos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agendamentos.dto.AvaliacaoResumidaDTO;
import com.agendamentos.services.AvaliacaoService;

@RestController
@RequestMapping(value = "/avaliacao")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping()
	public ResponseEntity<List<AvaliacaoResumidaDTO>> listarAvaliacoes(
			@RequestParam(required = false) Integer dia,
	        @RequestParam(required = false) Integer mes,
	        @RequestParam(required = false) Integer ano
	) {
		return new ResponseEntity<>(avaliacaoService.listarAvaliacoes(dia, mes, ano), HttpStatus.OK);
	}
}
