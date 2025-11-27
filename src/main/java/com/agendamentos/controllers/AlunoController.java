package com.agendamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamentos.dto.AlunoDTO;
import com.agendamentos.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> encontrarAlunoPorId(@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(alunoService.encontrarAlunoPorId(id), HttpStatus.OK);
	}
}
