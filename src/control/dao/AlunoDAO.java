package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Aluno;
import model.Professor;
import control.dao.banco.ConnectionFactory;

public class AlunoDAO {

	private Connection connection;
	
	public AlunoDAO () {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrar(Aluno aluno) {
		String sql = "INSERT INTO Aluno " +
				"(cpf, nome, dataNascimento, logradouro, numero, complemento, bairro, cidade, cep, uf)" +
				" VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, aluno.getCpf());
			stmt.setString(2, aluno.getNome());
			stmt.setDate(3, aluno.getDataNascimento());
			stmt.setString(4, aluno.getLogradouro());
			stmt.setInt(5, aluno.getNumero());
			stmt.setString(6, aluno.getComplemento());
			stmt.setString(7, aluno.getBairro());
			stmt.setString(8, aluno.getCidade());
			stmt.setInt(9, aluno.getCep());
			stmt.setString(10, aluno.getUF());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
