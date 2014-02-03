package model;

import java.util.List;

public class Curso {
	
	private Integer codigo;
	private String nome;
	private String descricaoConteudo;
	private Double valor = 0.0;
	private Integer limite;
	private List<Turma> turmas;
	
	public Curso() {

	}

	public Curso(String nome2, String descricao, Integer limite2) {
		nome = nome2;
		descricaoConteudo = descricao;
		limite = limite2;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoConteudo() {
		return descricaoConteudo;
	}

	public void setDescricaoConteudo(String descricaoConteudo) {
		this.descricaoConteudo = descricaoConteudo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	@Override
	public String toString() {
		return "Codigo: " + codigo + " \nNome: " + nome
				+ " \nDescrição do conteúdo: " + descricaoConteudo + " \nValor: "
				+ valor + " \nLimite: " + limite + " \nCódigos das turmas: ";
	}
	
	
	
}
