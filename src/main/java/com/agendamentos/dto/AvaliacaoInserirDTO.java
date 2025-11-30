package com.agendamentos.dto;

import java.time.LocalDateTime;

import com.agendamentos.entities.Aluno;
import com.agendamentos.entities.Professor;

public record AvaliacaoInserirDTO(
		Long id,
		LocalDateTime diaHora,
		Double preco,
		String status,
		Aluno aluno,
		Professor professor
		) {

}
