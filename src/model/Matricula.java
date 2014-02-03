package model;

import java.sql.Date;

public class Matricula {
	private Date data;
	private Double valorPago;
	private Turma turma;
	private Aluno aluno;
	
	public Matricula(Aluno aluno, Turma turma, Date data, double valorPago){
		this.aluno = aluno;
		this.turma = turma;
		this.data = data;
		this.valorPago = valorPago;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Matricula() {
		
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	
	
}
