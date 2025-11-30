package com.agendamentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamentos.dto.AvaliacaoResumidaDTO;
import com.agendamentos.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	public List<AvaliacaoResumidaDTO> listarAvaliacoes(Integer dia, Integer mes, Integer ano) {
		return avaliacaoRepository.listarAvaliacoes(dia, mes, ano);
	}
}
