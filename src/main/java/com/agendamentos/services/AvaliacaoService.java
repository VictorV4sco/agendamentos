package com.agendamentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agendamentos.dto.AvaliacaoInserirDTO;
import com.agendamentos.dto.AvaliacaoResumidaDTO;
import com.agendamentos.entities.Avaliacao;
import com.agendamentos.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Transactional(readOnly = true)
	public List<AvaliacaoResumidaDTO> listarAvaliacoes(Integer dia, Integer mes, Integer ano) {
		return avaliacaoRepository.listarAvaliacoes(dia, mes, ano);
	}
	
	@Transactional
	public AvaliacaoInserirDTO inserirAvaliacao(AvaliacaoInserirDTO dto) {
		Avaliacao avaliacao = new Avaliacao();
		preencherAvaliacao(avaliacao, dto);
		Avaliacao AvaliacaoSalva = avaliacaoRepository.save(avaliacao);
		
		return new AvaliacaoInserirDTO(AvaliacaoSalva.getId(), AvaliacaoSalva.getDiaHora(), 
				AvaliacaoSalva.getPreco(), AvaliacaoSalva.getStatus(), AvaliacaoSalva.getAluno(), AvaliacaoSalva.getProfessor());
	}
	
	@Transactional
	public AvaliacaoInserirDTO atualizarAvaliacao(Long id, AvaliacaoInserirDTO dto) {
	    Avaliacao avaliacao = avaliacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
	    preencherAvaliacao(avaliacao, dto);
	    Avaliacao avaliacaoAtualizada = avaliacaoRepository.save(avaliacao);

	    return new AvaliacaoInserirDTO(avaliacaoAtualizada.getId(), avaliacaoAtualizada.getDiaHora(), avaliacaoAtualizada.getPreco(), 
	    		avaliacaoAtualizada.getStatus(), avaliacaoAtualizada.getAluno(), avaliacaoAtualizada.getProfessor());
	}

	private void preencherAvaliacao(Avaliacao avaliacao, AvaliacaoInserirDTO dto) {
	    avaliacao.setDiaHora(dto.diaHora());
	    avaliacao.setPreco(dto.preco());
	    avaliacao.setStatus(dto.status());
	    avaliacao.setAluno(dto.aluno());
	    avaliacao.setProfessor(dto.professor());
	}

}
