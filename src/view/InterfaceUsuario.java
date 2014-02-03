package view;

import java.sql.Date;
import java.sql.Time;

import javax.swing.JOptionPane;

import model.Fachada;

public class InterfaceUsuario {
	
	public static void menu() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Olá, você está usando o sistema para manuntenção de cursos de aperfeiçoamento."
				+ "\n\nPor favor, selecione alguma das opções abaixo: "
				+ "\n1. Manter curso"
				+ "\n2. Manter turma"
				+ "\n0. Sair...\n\n").toString());
		
		switch (opcao) {
		case 1:
			manterCurso();
			break;
		case 2:
			manterTurma();
			break;
		case 3:
			manterProfessor();
			break;
		case 0:
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
			menu();
			break;
		}
		
	}
	
	
	
	public static void manterCurso() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "\tMenu Manter Cursos\t."
				+ "\n\nPor favor, selecione alguma das opções abaixo: "
				+ "\n1. Cadastrar"
				+ "\n2. Alterar"
				+ "\n3. Consultar"
				+ "\n4. Excluir"
				+ "\n0. Voltar...\n\n").toString());
		
		switch (opcao) {
		case 1:
			cadastrarCurso();
			manterCurso();
			break;
		case 2:
			alterarCurso();
			manterCurso();
			break;
		case 3:
			consultarCursos();
			manterCurso();
			break;
		case 4:
			excluirCurso();
			manterCurso();
			break;
		case 0:
			menu();
		default:
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
			manterCurso();
			break;
		}
	}
	
	public static void manterProfessor() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "\tMenu Manter Professor\t."
				+ "\n\nPor favor, selecione alguma das opções abaixo: "
				+ "\n1. Cadastrar"
				+ "\n2. Alterar"
				+ "\n3. Consultar"
				+ "\n4. Excluir"
				+ "\n0. Voltar...\n\n").toString());
		
		switch (opcao) {
		case 1:
			cadastrarProfessor();
			manterProfessor();
			break;
		case 2:
			alterarProfessor();
			manterProfessor();
			break;
		case 3:
			consultarProfessores();
			manterProfessor();
			break;
		case 4:
			excluirProfessor();
			manterProfessor();
			break;
		case 0:
			menu();
		default:
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
			manterCurso();
			break;
		}
	}

	
	public static void manterTurma() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "\tMenu Manter Turmas\t."
				+ "\n\nPor favor, selecione alguma das opções abaixo: "
				+ "\n1. Cadastrar"
				+ "\n2. Alterar"
				+ "\n3. Consultar"
				+ "\n4. Excluir"
				+ "\n0. Voltar...\n\n").toString());
		
		switch (opcao) {
		case 1:
			cadastrarTurma();
			manterTurma();
			break;
		case 2:
			alterarTurma();
			manterTurma();
			break;
		case 3:
			consultarTurmas();
			manterTurma();
			break;
		case 4:
			excluirTurma();
			manterTurma();
			break;
		case 0:
			menu();
		default:
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
			manterTurma();
			break;
		}
	}
		
	public static void cadastrarProfessor() {
		JOptionPane.showMessageDialog(null,"Para cadastrar um professor você deve preencher os campos que aparecerão a seguir.");
		
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF do professor: ").toString());
		String nome = JOptionPane.showInputDialog("Digite o nome do professor: ").toString();
		int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do professor: ").toString());
		double valorDaHora = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da hora: ").toString());
		
		Fachada.getInstance().cadastrarProfessor(cpf, nome, telefone, valorDaHora);		
	}
	
	public static void alterarProfessor() {
		Integer cpf = Integer.parseInt(JOptionPane.showInputDialog("Para alterar algum professor você precisa digitar o cpf. Se existir, você poderá alterar: "
				+ "\n\nDigite cpf: ").toString());
		
		if (Fachada.getInstance().consultarProfessor(cpf)) {
			JOptionPane.showMessageDialog(null, "O professor é válido. Para alterá-lo, preencha os campos que aparecerão.");
			
			String nome = JOptionPane.showInputDialog("Digite o nome do curso: ").toString();
			int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do professor: ").toString());
			Double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor por hora: ").toString());
			
			Fachada.getInstance().alterarProfessor(cpf, nome, telefone, valorHora);
		} else {
			JOptionPane.showMessageDialog(null, "Professor inv�lido");
		}		
	}
	
	public static void consultarProfessores() {
		JOptionPane.showMessageDialog(null, "Assim que você clicar em OK, aparecerão os cursos cadastrados.");
		
		String professores = Fachada.getInstance().consultarProfessores();
		
		if (professores.isEmpty())
			JOptionPane.showMessageDialog(null, "Não há cursos cadastrados.");
		else
			JOptionPane.showMessageDialog(null, professores);
	}
	
	public static void excluirProfessor() {
		Integer cpf = Integer.parseInt(JOptionPane.showInputDialog("Para excluir algum curso você precisa digitar o cpf. Se existir, você poderá excluir: "
				+ "\n\nDigite o código: ").toString());
		if (Fachada.getInstance().consultarProfessor(cpf)){
			Fachada.getInstance().excluirProfessor(cpf);
			JOptionPane.showMessageDialog(null, "Professor exclu�do com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Professor inexistente");
		}
	}
	
	public static void cadastrarCurso() {
		JOptionPane.showMessageDialog(null,"Para cadastrar um curso você deve preencher os campos que aparecerão a seguir.");
		
		String nome = JOptionPane.showInputDialog("Digite o nome do curso: ").toString();
		String descricao = JOptionPane.showInputDialog("Digite a descrição do conteúdo: ").toString();
		Double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do curso: ").toString());
		Integer limite = Integer.parseInt(JOptionPane.showInputDialog("Digite o limite de turmas: ").toString());
		
		Fachada.getInstance().cadastrarCurso(nome, descricao, valor, limite);		
	}
	
	public static void alterarCurso() {
		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Para alterar algum curso você precisa digitar o código. Se existir, você poderá alterar: "
				+ "\n\nDigite o código: ").toString());
		
		if (Fachada.getInstance().consultarCurso(codigo)) {
			JOptionPane.showMessageDialog(null, "O curso é válido. Para alterá-lo, preencha os campos que aparecerão.");
			
			String nome = JOptionPane.showInputDialog("Digite o nome do curso: ").toString();
			String descricao = JOptionPane.showInputDialog("Digite a descrição do conteúdo: ").toString();
			Double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do curso: ").toString());
			Integer limite = Integer.parseInt(JOptionPane.showInputDialog("Digite o limite de turmas: ").toString());
			
			Fachada.getInstance().alterarCurso(codigo, nome, descricao, valor, limite);	
		}		
	}
	
	public static void consultarCursos() {
		JOptionPane.showMessageDialog(null, "Assim que você clicar em OK, aparecerão os cursos cadastrados.");
		
		String cursos = Fachada.getInstance().consultarCursos();
		
		if (cursos.isEmpty())
			JOptionPane.showMessageDialog(null, "Não há cursos cadastrados.");
		else
			JOptionPane.showMessageDialog(null, cursos);
	}
	
	public static void excluirCurso() {
		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Para excluir algum curso você precisa digitar o código. Se existir, você poderá excluir: "
				+ "\n\nDigite o código: ").toString());
		
		Fachada.getInstance().excluirCurso(codigo);
	}
	
	public static void cadastrarTurma() {
		JOptionPane.showMessageDialog(null,"Para cadastrar uma turma você deve preencher os campos que aparecerão a seguir.");
		
		Integer codigoCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso: ").toString());
		
		if (Fachada.getInstance().consultarCurso(codigoCurso)) {
			
			Date dataInicio = Date.valueOf(JOptionPane.showInputDialog("Digite o data de de inicio turma: ").toString());
			Date dataTermino = Date.valueOf(JOptionPane.showInputDialog("Digite a data de termino: ").toString());
			Time horaInicio = Time.valueOf(JOptionPane.showInputDialog("Digite a hora de inicio: ").toString());
			Time horaTermino = Time.valueOf(JOptionPane.showInputDialog("Digite a hora de termino: ").toString());
			char turno = JOptionPane.showInputDialog("Digite (M)atutino, (V)espertino ou (N)oturno: ").toString().charAt(0);
			Integer codigoProfessor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor: ").toString());
			
			// verificar se professor existe
			codigoProfessor = Fachada.getInstance().consultarProfessor(codigoProfessor) == false ? 0 : codigoProfessor;
			
			Fachada.getInstance().cadastrarTurma(codigoCurso, dataInicio, dataTermino, horaInicio, horaTermino, turno, codigoProfessor);
			
		} else
			JOptionPane.showMessageDialog(null, "Curso inexistente!");
		
		
	}
	
	public static void alterarTurma() {
		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Para alterar alguma turma você precisa digitar o código. Se existir, você poderá alterar: "
				+ "\n\nDigite o código: ").toString());
		
		Integer codigoCurso = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso: ").toString());
		
		if (Fachada.getInstance().consultarCurso(codigoCurso)) {
			
			Date dataInicio = Date.valueOf(JOptionPane.showInputDialog("Digite o data de de inicio turma: ").toString());
			Date dataTermino = Date.valueOf(JOptionPane.showInputDialog("Digite a data de termino: ").toString());
			Time horaInicio = Time.valueOf(JOptionPane.showInputDialog("Digite a hora de inicio: ").toString());
			Time horaTermino = Time.valueOf(JOptionPane.showInputDialog("Digite a hora de termino: ").toString());
			char turno = JOptionPane.showInputDialog("Digite (M)atutino, (V)espertino ou (N)oturno: ").toString().charAt(0);
			Integer codigoProfessor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor: ").toString());
			
			// verificar se professor existe
			codigoProfessor = Fachada.getInstance().consultarProfessor(codigoProfessor) == false ? 0 : codigoProfessor;
			
			Fachada.getInstance().alterarTurma(codigo, codigoCurso, dataInicio, dataTermino, horaInicio, horaTermino, turno, codigoProfessor);
			
		} else
			JOptionPane.showMessageDialog(null, "Curso inexistente!");
				
	}
	
	public static void consultarTurmas() {
		JOptionPane.showMessageDialog(null, "Assim que você clicar em OK, aparecerão as turmas cadastrados.");
		
		String turmas = Fachada.getInstance().consultarTurmas();
		
		if (turmas.isEmpty())
			JOptionPane.showMessageDialog(null, "Não há turmas cadastradas.");
		else
			JOptionPane.showMessageDialog(null, turmas);
	}
	
	public static void excluirTurma() {
		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Para excluir alguma turma você precisa digitar o código. Se existir, você poderá excluir: "
				+ "\n\nDigite o código: ").toString());
		
		Fachada.getInstance().excluirTurma(codigo);
	}
	
	public static void main(String[] args) {
		menu();
	}
}
