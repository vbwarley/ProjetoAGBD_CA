package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Turma {
	private Integer codigo;
	private Date dataInicio;
	private Date dataFim;
	private Time horaInicio;
	private Time horaTermino;
	private char turno;
	private Curso curso;
	private Professor professor;
	private ArrayList<Aluno> aluno = new ArrayList<Aluno>();
	
	public Turma() {
		
	}

	public Turma(Curso curso, Date dataInicio, Date dataTermino,
			Time horaInicio, Time horaTermino, char turno,
			Professor professor) {
		this.curso = curso;
		this.dataInicio = dataInicio;
		this.dataFim = dataTermino;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.turno = turno;
		this.professor = professor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Time horaTermino) {
		this.horaTermino = horaTermino;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		return "Turma:\ncodigo: " + codigo + " \ndataInicio: " + dataInicio
				+ " \ndataFim: " + dataFim + " \nhoraInicio: " + horaInicio
				+ " \nhoraTermino: " + horaTermino + " \nturno: " + turno
				+ " \ncurso: " + curso.getNome() + " \nprofessor: " + professor.getNome();
	}
	
	
}
