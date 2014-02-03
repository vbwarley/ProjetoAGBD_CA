package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
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
		
		new TelefoneDAO().cadastrar(aluno.getTelefone(), aluno.getCpf());
	}
	
	public Aluno consultar(Integer cpf) {
		String sql = "SELECT * FROM Aluno WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
						
			if (rs.next()) { //Lembrar de ajeitar o telefone
				Aluno aluno = new Aluno(cpf, rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				aluno.setTelefone(new TelefoneDAO().consultar(rs.getInt(1)));
				stmt.close();
				return aluno;
			} else 
				return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Aluno aluno) {
		String sql = "UPDATE Aluno SET nome = ?, dataNascimento = ?, logradouro = ?, "
				+ "numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, uf = ? WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, String.valueOf(aluno.getDataNascimento()));
			stmt.setString(3, aluno.getLogradouro());
			stmt.setInt(4, aluno.getNumero());
			stmt.setString(5, aluno.getComplemento());
			stmt.setString(6, aluno.getBairro());
			stmt.setString(7, aluno.getCidade());
			stmt.setInt(8, aluno.getCep());
			stmt.setString(9, aluno.getUF());
			stmt.setInt(10, aluno.getCpf());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// nao testado
		public List<Aluno> consultar() {
			String sql = "SELECT * FROM Aluno";
			
			try {
				List<Aluno> alunos = new ArrayList<Aluno>();
				PreparedStatement stmt = connection.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) { //Lembrar de alterar o Telefone
					Aluno aluno = new Aluno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10));
				
					aluno.setTelefone(new TelefoneDAO().consultar(rs.getInt(1)));
					
					alunos.add(aluno);
				}

				rs.close();
				stmt.close();
				return alunos;			
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	public void excluir(Aluno aluno) {
		String sql = "DELETE FROM Aluno WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, aluno.getCpf());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
}
