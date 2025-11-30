package com.agendamentos.dto;

import java.time.LocalDateTime;

public record AvaliacaoResumidaDTO(
		Long id,
		LocalDateTime diaHora,
		String aluno,
		String status,
		String professor
		) {

}
