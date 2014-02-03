package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.dao.banco.ConnectionFactory;
import model.Professor;
import model.Turma;

public class ProfessorDAO {

	private Connection connection;
	
	public ProfessorDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrar(Professor professor) {
		String sql = "INSERT INTO Professor " +
				"(cpf, nome, telefone, valorHora)" +
				" VALUES (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, professor.getCpf());
			stmt.setString(2, professor.getNome());
			stmt.setInt(3, professor.getTelefone());
			stmt.setDouble(4, professor.getValorHoraAula());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(Professor professor) {
		String sql = "UPDATE Professor SET nome = ?, telefone = ?, valorHoraAula = ? WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, professor.getNome());
			stmt.setInt(2, professor.getTelefone());
			stmt.setDouble(3, professor.getValorHoraAula());
			stmt.setDouble(4, professor.getCpf());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Professor consultar(Integer cpf) {
		String sql = "SELECT * FROM Professor WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, cpf);
			
			ResultSet rs = stmt.executeQuery();
						
			if (rs.next()) {
				Professor professor = new Professor(cpf, rs.getString(2), rs.getInt(3), rs.getDouble(4));
				
				return professor;
			} else 
				return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// nao testado
	public List<Professor> consultar() {
		String sql = "SELECT * FROM Professor";
		try {
			List<Professor> professores = new ArrayList<Professor>();
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Professor professor = new Professor(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));

				professores.add(professor);
			}

			rs.close();
			stmt.close();
			return professores;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Professor professor) {
		String sql = "DELETE FROM Professor WHERE cpf = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, professor.getCpf());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
