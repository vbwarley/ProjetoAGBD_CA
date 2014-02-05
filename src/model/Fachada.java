package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import control.dao.AlunoDAO;
import control.dao.CursoDAO;
import control.dao.MatriculaDAO;
import control.dao.ProfessorDAO;
import control.dao.TurmaDAO;

public class Fachada {
	private static Fachada instance = new Fachada();

	public Fachada() {

	}

	public static Fachada getInstance() {
		return instance;
	}

	public void cadastrarCurso(String nome, String descricao,
			Integer limite) {
		Curso curso = new Curso(nome, descricao, limite);
		new CursoDAO().cadastrar(curso);		
	}

	public boolean consultarCurso(Integer codigo) {
		return new CursoDAO().consultar(codigo) == null ? false : true;
	}
	
	public boolean verLimite(Integer codigo) {
		Curso c = new CursoDAO().consultar(codigo);
		return (c == null) ? false : (c.getLimite() == c.getTurmas().size()) ? false : true;
	}
	
	public boolean consultarProfessor(Integer cpf) {
		return new ProfessorDAO().consultar(cpf) == null ? false : true;
	}
	
	public String consultarProfessores() {
		List<Professor> professores = new ArrayList<Professor>();

		professores = new ProfessorDAO().consultar();

		String pmostrar = "";

		for (Professor p : professores) 
			pmostrar += p.toString();
			pmostrar += "\n\n-------------------\n\n";

		return pmostrar;
	}

	public void alterarCurso(Integer codigo, String nome, String descricao,
			Integer limite) {
		Curso curso = new Curso(nome, descricao, limite);
		curso.setCodigo(codigo);
		new CursoDAO().alterar(curso);
	}
	
	public void alterarProfessor(Integer cpf, String nome, int telefone, double valorHora) {
		Professor professor = new Professor(cpf, nome, telefone, valorHora);
		
		new ProfessorDAO().alterar(professor);
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
	
	public void excluirProfessor(Integer cpf) {
		ProfessorDAO pdao = new ProfessorDAO();
		Professor professor = pdao.consultar(cpf);
		pdao.excluir(professor);
	}
	
	public void cadastrarAluno(int cpf, String nome, String dataNascimento, int dddTelefone, int telefoneNumero, String tipo, String logradouro, int numero,
			String complemento, String bairro, String cidade, int cep, String uf) {
		
		Telefone telefone = new Telefone(dddTelefone, numero, tipo, cpf);
		
		Aluno aluno = new Aluno(cpf, nome, dataNascimento, logradouro, numero, complemento, bairro, cidade, cep, uf);
		aluno.addTelefone(telefone);
		
		new AlunoDAO().cadastrar(aluno);
		
	}
	
	public Double totalArrecadado() {
		return new CursoDAO().totalArrecadado();
	}
	
	
	public void alterarAluno(int cpf, String nome, String dataNascimento, int dddTelefone, int telefoneNumero, String tipo, String logradouro, int numero,
			String complemento, String bairro, String cidade, int cep, String uf) {
		
		Aluno aluno = new Aluno(cpf, nome, dataNascimento, logradouro, numero, complemento, bairro, cidade, cep, uf);

		new AlunoDAO().alterar(aluno);
		
	}
	
	public void matricular (int cpf, int codigo, Date data, double valorPago){
		
		Aluno aluno = new AlunoDAO().consultar(cpf);
		Turma turma = new TurmaDAO().consultar(codigo);
		
		Matricula matricula = new Matricula(aluno, turma, data, valorPago);
		new MatriculaDAO().matricular(matricula);
		
	}
	
	public boolean consultarAluno(Integer cpf) {
		return new AlunoDAO().consultar(cpf) == null ? false : true;
	}
	
	public String consultarAlunos() {
		List<Aluno> alunos = new ArrayList<Aluno>();

		alunos = new AlunoDAO().consultar();

		String aMostrar = "";

		for (Aluno a : alunos) 
			aMostrar += a.toString() + "\n\n----------------------\n\n";

		return aMostrar;
	}

	public void excluirAluno(Integer cpf) {
		AlunoDAO adao = new AlunoDAO();
		Aluno aluno = adao.consultar(cpf);
		adao.excluir(aluno);
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
	
	public void cadastrarProfessor(int cpf, String nome, int telefone, double valorHora){
		
		Professor professor = new Professor(cpf, nome, telefone, valorHora);
		
		new ProfessorDAO().cadastrar(professor);
		
	}
	
	
	public void alteraProfessor(int cpf, String nome, int telefone, double valorHora) {

		Professor professor = new Professor(cpf, nome, telefone, valorHora);

		new ProfessorDAO().alterar(professor);

	}
	
}


