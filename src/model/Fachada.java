package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import control.dao.CursoDAO;
import control.dao.ProfessorDAO;
import control.dao.TurmaDAO;

public class Fachada {
	private static Fachada instance = new Fachada();
	
	public Fachada() {
		
	}
	
	public static Fachada getInstance() {
		return instance;
	}

	public void cadastrarCurso(String nome, String descricao, Double valor,
			Integer limite) {
		Curso curso = new Curso(nome, descricao, valor, limite);
		new CursoDAO().cadastrar(curso);		
	}

	public boolean consultarCurso(Integer codigo) {
		return new CursoDAO().consultar(codigo) == null ? false : true;
	}

	public void alterarCurso(Integer codigo, String nome, String descricao,
			Double valor, Integer limite) {
		Curso curso = new Curso(nome, descricao, valor, limite);
		curso.setCodigo(codigo);
		new CursoDAO().alterar(curso);
	}

	public String consultarCursos() {
		List<Curso> cursos = new ArrayList<Curso>();
		List<Turma> turmas = new ArrayList<Turma>();
		
		cursos = new CursoDAO().consultar();
		turmas = new TurmaDAO().consultar();
				
		String cmostrar = "";
		
		for (Curso c : cursos) 
			cmostrar += c.toString();
			// se existir alguma turma
			if (turmas != null)
				for (Turma t : turmas) {
					// adicione o codigo dela na String cmostrar
					cmostrar += t.getCodigo();
					// se a turma for a penultima adicione 'e', senão adicione ',' || +1 serve pra igualar as posicoes
					// pq turmas começa no indice 0
					if (turmas.lastIndexOf(t)+1 == turmas.size() - 1) 
						cmostrar += " e ";
					// verifica se a turma não é a última
					else if (!(turmas.lastIndexOf(t)+1 == turmas.size()))
						cmostrar += ", "; // se não for, adiciona a vírgula					
				}
			else
				cmostrar += 0;
			cmostrar += "\n\n-------------------\n\n";
		
		return cmostrar;
	}

	public void excluirCurso(Integer codigo) {
		CursoDAO cdao = new CursoDAO();
		Curso curso = cdao.consultar(codigo);
		cdao.excluir(curso);
	}

	public void cadastrarTurma(Integer codigoCurso, Date dataInicio, Date dataTermino,
			Time horaInicio, Time horaTermino, char turno, Integer codigoProfessor) {
		
		Turma turma = new Turma(new CursoDAO().consultar(codigoCurso), dataInicio, dataTermino, horaInicio, horaTermino, turno,
				new ProfessorDAO().consultar(codigoProfessor));
		
		new TurmaDAO().cadastrar(turma);	
		
	}

	public void alterarTurma(Integer codigo, Integer codigoCurso, Date dataInicio, Date dataTermino,
			Time horaInicio, Time horaTermino, char turno, Integer codigoProfessor) {
		
		Turma turma = new Turma(new CursoDAO().consultar(codigoCurso), dataInicio, dataTermino, horaInicio, horaTermino, turno,
				new ProfessorDAO().consultar(codigoProfessor));
		
		turma.setCodigo(codigo);
		
		new TurmaDAO().alterar(turma);
		
	}

	public boolean consultarTurma(Integer codigo) {
		return new TurmaDAO().consultar(codigo) == null ? false : true;
	}

	public String consultarTurmas() {
		List<Turma> turmas = new ArrayList<Turma>();
		
		turmas = new TurmaDAO().consultar();
				
		String tmostrar = "";
		
		for (Turma t : turmas) 
			tmostrar += t.toString() + "\n\n----------------------\n\n";
			
		return tmostrar;
	}

	public void excluirTurma(Integer codigo) {
		TurmaDAO tdao = new TurmaDAO();
		Turma turma = tdao.consultar(codigo);
		tdao.excluir(turma);
		
	}
}
