package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private Integer cpf;
	private String nome;
	private Date dataNascimento;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private Integer cep;
	private String cidade;
	private String UF;
	private List<Telefone> telefone;
	private Turma turma;
	
	public Aluno(int cpf, String nome, String dataNascimento, String logradouro, int numero,
			String complemento, String bairro, String cidade, int cep, String uf) {
		
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = Date.valueOf(dataNascimento);
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.UF = uf;
		
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	public void addTelefone(Telefone telefone){
		this.telefone.add(telefone);
	}
	
	public String toString(){
		
		String numeros = "";
		
		for (int i = 0; i < this.telefone.size(); i++){
			 numeros = "\n" + this.telefone.get(i).toString(); 
		}
		
		String info = "CPF: " + this.cpf + "\nNome: " + this.nome + "\nData de nascimento: " 
		+ this.dataNascimento	+ "\nLogradouro: " + this.logradouro + "\nNumero: " 
		+ this.numero + "\nComplemento: " + this.complemento + "\nBairro: "	+ this.bairro 
		+ "\nCEP: "	+ this.cep + "\nCidade: " + this.cidade + "\nUF: " + "" + this.UF 
		+ "\nTelefones: " + numeros + "\nTurma: " + this.turma;
		
		return info;
	
	}
	
}
