package com.agendamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamentos.dto.AlunoDTO;
import com.agendamentos.entities.Aluno;
import com.agendamentos.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public AlunoDTO encontrarAlunoPorId(Long id) throws Exception {
		Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		return new AlunoDTO(aluno.getId(), aluno.getName(), aluno.getEmail(), aluno.getPhone());
	}
}
