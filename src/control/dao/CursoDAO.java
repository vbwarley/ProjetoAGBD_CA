package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.dao.banco.ConnectionFactory;
import model.Curso;
import model.Turma;

public class CursoDAO {
	
	private Connection connection;
	
	public CursoDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void cadastrar(Curso curso) {
		String sql = "INSERT INTO Curso " +
				"(nome, descricaoConteudo, valor, limite)" +
				" VALUES (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, curso.getNome());
			stmt.setString(2, curso.getDescricaoConteudo());
			stmt.setDouble(3, curso.getValor());
			stmt.setInt(4, curso.getLimite());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public Curso consultar(Integer codigo) {
		String sql = "SELECT * FROM Curso WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			ResultSet rs = stmt.executeQuery();
						
			if (rs.next()) {
				Curso curso = new Curso();
				
				curso.setCodigo(codigo);
				curso.setNome(rs.getString("nome"));
				curso.setDescricaoConteudo(rs.getString("descricaoConteudo"));
				curso.setValor(rs.getDouble("valor"));
				curso.setLimite(rs.getInt("limite"));
				
				return curso;
			} else 
				return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
	public void alterar(Curso curso) {
		String sql = "UPDATE Curso SET nome = ?, descricaoConteudo = ?,"
				+ "valor = ?, limite = ? WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, curso.getNome());
			stmt.setString(2, curso.getDescricaoConteudo());
			stmt.setDouble(3, curso.getValor());
			stmt.setInt(4, curso.getLimite());
			stmt.setInt(5, curso.getCodigo());
			
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public void excluir(Curso curso) {
		String sql = "DELETE FROM Curso WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, curso.getCodigo());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	public List<Curso> consultar() {
		String sql = "SELECT * FROM Curso";
		try {
			List<Curso> cursos = new ArrayList<Curso>();
			List<Turma> turmas = null;
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				Curso curso = new Curso();
				turmas = new TurmaDAO().consultar();
				
				curso.setCodigo(rs.getInt("codigo"));
				curso.setNome(rs.getString("nome"));
				curso.setDescricaoConteudo(rs.getString("descricaoConteudo"));
				curso.setValor(rs.getDouble("valor"));
				curso.setLimite(rs.getInt("limite"));
				
				for (Turma t: turmas)
					if (curso.equals(t.getCurso()))
						curso.getTurmas().add(t);
				
				cursos.add(curso);
			}
			
			rs.close();
			stmt.close();
			return cursos;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
