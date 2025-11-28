package com.agendamentos.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.agendamentos.enums.PagamentoEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime diaHora;
	private Double preco;
	private boolean pagamento;
	private PagamentoEnum status;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	public Avaliacao() {
	}

	public Avaliacao(Long id, LocalDateTime diaHora, Double preco, boolean pagamento, PagamentoEnum status, Aluno aluno,
			Professor professor) {
		super();
		this.id = id;
		this.diaHora = diaHora;
		this.preco = preco;
		this.pagamento = pagamento;
		this.status = status;
		this.aluno = aluno;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(LocalDateTime diaHora) {
		this.diaHora = diaHora;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}

	public PagamentoEnum getStatus() {
		return status;
	}

	public void setStatus(PagamentoEnum status) {
		this.status = status;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, diaHora, id, pagamento, preco, professor, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliacao other = (Avaliacao) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(diaHora, other.diaHora)
				&& Objects.equals(id, other.id) && pagamento == other.pagamento && Objects.equals(preco, other.preco)
				&& Objects.equals(professor, other.professor) && status == other.status;
	}
	
	
}
