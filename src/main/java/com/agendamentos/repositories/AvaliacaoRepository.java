package com.agendamentos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agendamentos.dto.AvaliacaoResumidaDTO;
import com.agendamentos.entities.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

	@Query("""
			    SELECT new com.agendamentos.dto.AvaliacaoResumidaDTO(
			        a.id,
			        a.diaHora,
			        a.aluno.name,
			        a.status,
			        a.professor.name
			    )
			    FROM Avaliacao a
			    JOIN a.aluno al
			    JOIN a.professor p
			    WHERE (:dia IS NULL OR FUNCTION('DAY', a.diaHora) = :dia)
			   		AND (:mes IS NULL OR FUNCTION('MONTH', a.diaHora) = :mes)
			   		AND (:ano IS NULL OR FUNCTION('YEAR', a.diaHora) = :ano)
			""")
	List<AvaliacaoResumidaDTO> listarAvaliacoes(Integer dia, Integer mes, Integer ano);

}
