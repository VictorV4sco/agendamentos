package com.agendamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamentos.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
