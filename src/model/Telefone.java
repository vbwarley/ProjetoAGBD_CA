package model;

public class Telefone {
	
	private Integer ddd;
	private Integer numero;
	private String tipo;
	private int cpf;
	
	public Telefone(int ddd, int numero, String tipo, int cpf) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.cpf = cpf;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
