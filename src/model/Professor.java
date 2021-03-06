package model;

public class Professor {
	private Integer cpf;
	private String nome;
	private Integer telefone;
	private Double valorHoraAula;
	
	public Professor(int cpf, String nome, int telefone, double valorHora) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.valorHoraAula = valorHora;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Double getValorHoraAula() {
		return valorHoraAula;
	}

	public void setValorHoraAula(Double valorHoraAula) {
		this.valorHoraAula = valorHoraAula;
	}

	@Override
	public String toString() {
		return "Professor "+"\nCPF: " + cpf + "\nNome: " + nome + "\nTelefone: "
				+ telefone + "\nValorHoraAula: " + valorHoraAula;
	}

	
	
}
