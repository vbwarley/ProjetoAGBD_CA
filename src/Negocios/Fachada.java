package Negocios;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Fachada {
	private static Fachada instance = new Fachada();
	
	public Fachada() {
		
	}
	
	public static Fachada getInstance() {
		return instance;
	}

	public void cadastrarCurso(String nome, String descricao, Double valor,
			Integer limite) {
		// TODO Auto-generated method stub
		
	}

	public boolean consultarCurso(Integer codigo) {
		// TODO Auto-generated method stub
		return true;
	}

	public void alterarCurso(Integer codigo, String nome, String descricao,
			Double valor, Integer limite) {
		// TODO Auto-generated method stub
		
	}

	public String consultarCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluirCurso(Integer codigo) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarTurma(Date dataInicio, Date dataTermino,
			Time horaInicio, Time horaTermino, char turno) {
		// TODO Auto-generated method stub
		
	}

	public void alterarTurma(Date dataInicio, Date dataTermino,
			Time horaInicio, Time horaTermino, char turno) {
		// TODO Auto-generated method stub
		
	}

	public boolean consultarTurma(Integer codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	public String consultarTurmas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluirTurma(Integer codigo) {
		// TODO Auto-generated method stub
		
	}
}
