package com.agendamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamentos.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
