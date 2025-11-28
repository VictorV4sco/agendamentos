package com.agendamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamentos.dto.AlunoDTO;
import com.agendamentos.entities.Professor;
import com.agendamentos.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public AlunoDTO encontrarAlunoPorId(Long id) throws Exception {
		Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		return new AlunoDTO(professor.getId(), professor.getName(), professor.getEmail(), professor.getPhone());
	}
}
