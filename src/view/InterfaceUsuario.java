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
				+ "\n3. Manter professor"
				+ "\n4. Manter aluno"
				+ "\n5. Matricular aluno"
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
		case 4:
			manterAluno();
			break;
		case 5:
			matricularAluno();
			menu();
			break;
		case 0:
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
			menu();
			break;
		}
		
	}
	
	
	public static void manterAluno() {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "\tMenu Manter Professor\t."
				+ "\n\nPor favor, selecione alguma das opções abaixo: "
				+ "\n1. Cadastrar"
				+ "\n2. Alterar"
				+ "\n3. Consultar"
				+ "\n4. Excluir"
				+ "\n0. Voltar...\n\n").toString());
		
		switch (opcao) {
		case 1:
			cadastrarAluno();
			manterAluno();
			break;
		case 2:
			alterarAluno();
			manterAluno();
			break;
		case 3:
			consultarAluno();
			manterAluno();
			break;
		case 4:
			excluirAluno();
			manterAluno();
			break;
		case 0:
			menu();
		default:
			JOptionPane.showMessageDialog(null, "Opcão inválida!");
			manterCurso();
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
				+ "\n5. Ver total arrecadado"
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
		case 5:
			verTotalArrecadado();
			manterCurso();
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
	
	public static void cadastrarAluno() {
		JOptionPane.showMessageDialog(null,"Para cadastrar um aluno você deve preencher os campos que aparecerão a seguir.");
		
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF do aluno: ").toString());
		String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ").toString();
		String dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento: (aaaa-mm-dd)").toString();
		int dddTelefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o DDD do telefone do aluno: ").toString());
		int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero do telefone do aluno: ").toString());
		String tipo = JOptionPane.showInputDialog("Digite o tipo de telefone (ex.: Residencial): ").toString();
		String logradouro = JOptionPane.showInputDialog("Digite o logradouro do aluno: ").toString();
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero da casa: ").toString());
		String complemento = JOptionPane.showInputDialog("Digite o complemento do endere�o: ");
		String bairro = JOptionPane.showInputDialog("Digite o bairro do aluno: ");
		String cidade = JOptionPane.showInputDialog("Digite a cidade do aluno: ");
		int cep = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de telefone (ex.: Residencial): ").toString());
		String uf = JOptionPane.showInputDialog("Digite a abreviatura da UF onde o aluno mora (ex.: AL)");
		
		Fachada.getInstance().cadastrarAluno(cpf, nome, dataNascimento, dddTelefone, telefone, tipo, logradouro, numero, 
				complemento, bairro, cidade, cep, uf);
		JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
	}
	
	public static void alterarAluno() {
		Integer cpf = Integer.parseInt(JOptionPane.showInputDialog("Para alterar algum aluno você precisa digitar o cpf. Se existir, você poderá alterar: "
				+ "\n\nDigite cpf: ").toString());
		
		if (Fachada.getInstance().consultarAluno(cpf)) {
			JOptionPane.showMessageDialog(null, "O aluno é válido. Para alterá-lo, preencha os campos que aparecerão.");
			
			String nome = JOptionPane.showInputDialog("Digite o novo nome do aluno: ").toString();
			String dataNascimento = JOptionPane.showInputDialog("Digite a nova data de nascimento: (aaaa-mm-dd)").toString();
			int dddTelefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo DDD do telefone do aluno: ").toString());
			int telefone = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo n�mero do telefone do aluno: ").toString());
			String tipo = JOptionPane.showInputDialog("Digite o novo tipo de telefone (ex.: Residencial): ").toString();
			String logradouro = JOptionPane.showInputDialog("Digite o novo logradouro do aluno: ").toString();
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo n�mero da casa: ").toString());
			String complemento = JOptionPane.showInputDialog("Digite o novo complemento do endere�o: ");
			String bairro = JOptionPane.showInputDialog("Digite o novo bairro do aluno: ");
			String cidade = JOptionPane.showInputDialog("Digite a nova cidade do aluno: ");
			int cep = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo tipo de telefone (ex.: Residencial): ").toString());
			String uf = JOptionPane.showInputDialog("Digite a abreviatura da nova UF onde o aluno mora (ex.: AL)");
			
			Fachada.getInstance().alterarAluno(cpf, nome, dataNascimento, dddTelefone, telefone, tipo, logradouro, numero, 
					complemento, bairro, cidade, cep, uf);
			
			JOptionPane.showMessageDialog(null,"Aluno atualizado com sucesso");
			
		} else {
			JOptionPane.showMessageDialog(null, "aluno inv�lido");
		}		
	}
	
	public static void consultarAluno() {
		JOptionPane.showMessageDialog(null, "Assim que você clicar em OK, aparecerão os cursos cadastrados.");
		
		String alunos = Fachada.getInstance().consultarAlunos();
		
		if (alunos.isEmpty())
			JOptionPane.showMessageDialog(null, "Não há alunos cadastrados.");
		else
			JOptionPane.showMessageDialog(null, alunos);
	}
	
	public static void matricularAluno(){
		
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do aluno a ser matriculado: ").toString());
		
		if (Fachada.getInstance().consultarAluno(cpf)){
			int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo da turma").toString());
			if (Fachada.getInstance().consultarTurma(codigo)){
				
				Date data = Date.valueOf(JOptionPane.showInputDialog("Digite a data da matricula: ").toString());
				double valorPago = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor pago pelo aluno: ").toString());
				
				Fachada.getInstance().matricular(cpf, codigo, data, valorPago);
				
			} else {
				JOptionPane.showMessageDialog(null, "Turma inexistente");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Aluno inexistente");
		}
		
		
	}
	
	public static void excluirAluno() {
		Integer cpf = Integer.parseInt(JOptionPane.showInputDialog("Para excluir algum aluno você precisa digitar o cpf. Se existir, você poderá excluir: "
				+ "\n\nDigite o código: ").toString());
		if (Fachada.getInstance().consultarAluno(cpf)){
			Fachada.getInstance().excluirAluno(cpf);
			JOptionPane.showMessageDialog(null, "Aluno exclu�do com sucesso");
		} else {
			JOptionPane.showMessageDialog(null, "Professor inexistente");
		}
	}
		
	public static void verTotalArrecadado() {
		JOptionPane.showMessageDialog(null, "Ao clicar OK, você poderá ver o total arreacadado de todos os cursos.");
		
		Double total = Fachada.getInstance().totalArrecadado();
		if (total != null)
			JOptionPane.showMessageDialog(null, "Total arrecadado: " + total);
		else
			JOptionPane.showMessageDialog(null, "Não foi possível calcular o total. Provavelmente nenhum aluno foi matriculado.");
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
		Integer cpf = Integer.parseInt(JOptionPane.showInputDialog("Para excluir algum professor você precisa digitar o cpf. Se existir, você poderá excluir: "
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
		Integer limite = Integer.parseInt(JOptionPane.showInputDialog("Digite o limite de turmas: ").toString());
		
		Fachada.getInstance().cadastrarCurso(nome, descricao, limite);		
	}
	
	public static void alterarCurso() {
		Integer codigo = Integer.parseInt(JOptionPane.showInputDialog("Para alterar algum curso você precisa digitar o código. Se existir, você poderá alterar: "
				+ "\n\nDigite o código: ").toString());
		
		if (Fachada.getInstance().consultarCurso(codigo)) {
			JOptionPane.showMessageDialog(null, "O curso é válido. Para alterá-lo, preencha os campos que aparecerão.");
			
			String nome = JOptionPane.showInputDialog("Digite o nome do curso: ").toString();
			String descricao = JOptionPane.showInputDialog("Digite a descrição do conteúdo: ").toString();
			Integer limite = Integer.parseInt(JOptionPane.showInputDialog("Digite o limite de turmas: ").toString());
			
			Fachada.getInstance().alterarCurso(codigo, nome, descricao, limite);	
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
		
		if (Fachada.getInstance().consultarCurso(codigoCurso) && Fachada.getInstance().verLimite(codigoCurso) ) {
			
			Date dataInicio = Date.valueOf(JOptionPane.showInputDialog("Digite o data de de inicio turma: ").toString());
			Date dataTermino = Date.valueOf(JOptionPane.showInputDialog("Digite a data de termino: ").toString());
			Time horaInicio = Time.valueOf(JOptionPane.showInputDialog("Digite a hora de inicio: ").toString() + ":00");
			Time horaTermino = Time.valueOf(JOptionPane.showInputDialog("Digite a hora de termino: ").toString() + ":00");
			char turno = JOptionPane.showInputDialog("Digite (M)atutino, (V)espertino ou (N)oturno: ").toString().charAt(0);
			Integer codigoProfessor = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do professor: ").toString());
			
			// verificar se professor existe
			codigoProfessor = Fachada.getInstance().consultarProfessor(codigoProfessor) == false ? 0 : codigoProfessor;
			
			Fachada.getInstance().cadastrarTurma(codigoCurso, dataInicio, dataTermino, horaInicio, horaTermino, turno, codigoProfessor);
			
		} else
			JOptionPane.showMessageDialog(null, "Curso inexistente ou limite de turmas completo!");
		
		
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
