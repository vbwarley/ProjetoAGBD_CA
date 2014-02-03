package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Turma;
import dao.banco.ConnectionFactory;

public class TurmaDAO {
	private Connection connection;

	public TurmaDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void cadastrar(Turma turma) {
		String sql = "INSERT INTO Turma " +
				"(dataInicio, dataFim, horaInicio, horaFim, turno, codigoCurso, codigoProfessor)" +
				" VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setDate(1, turma.getDataInicio());
			stmt.setDate(2, turma.getDataFim());
			stmt.setTime(3, turma.getHoraInicio());
			stmt.setTime(4, turma.getHoraTermino());
			stmt.setString(5, String.valueOf(turma.getTurno()));
			stmt.setInt(6, turma.getCurso().getCodigo());
			stmt.setInt(7, turma.getProfessor().getCpf() );
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Turma turma) {
		String sql = "UPDATE Turma SET dataInicio = ?, dataFim = ?, horaInicio = ?, horaFim = ?,"
				+ " turno = ?, codigoCurso = ?, codigoProfessor = ? WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setDate(1, turma.getDataInicio());
			stmt.setDate(2, turma.getDataFim());
			stmt.setTime(3, turma.getHoraInicio());
			stmt.setTime(4, turma.getHoraTermino());
			stmt.setString(5, String.valueOf(turma.getTurno()));
			stmt.setInt(6, turma.getCurso().getCodigo());
			stmt.setInt(7, turma.getProfessor().getCpf() );
			stmt.setInt(8, turma.getCodigo());			
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Turma consultar(Integer codigo) {
		String sql = "SELECT * FROM Turma WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, codigo);
			
			ResultSet rs = stmt.executeQuery();
						
			if (rs.next()) {
				Turma turma = new Turma();
				
				turma.setCodigo(codigo);
				turma.setDataInicio(rs.getDate("dataInicio"));
				turma.setDataFim(rs.getDate("dataTermino"));
				turma.setHoraInicio(rs.getTime("horaInicio"));
				turma.setHoraTermino(rs.getTime("horaTermino"));
				turma.setTurno(rs.getString("turno").charAt(0)); // aqui pode dar erro :|
				turma.setCurso(new CursoDAO().consultar(rs.getInt("codigoCurso")));
				turma.setProfessor(new ProfessorDAO().consultar(rs.getInt("codigoProfessor")));
				
				return turma;
			} else 
				return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// nao testado
	public List<Turma> consultar() {
		String sql = "SELECT * FROM Turma";
		try {
			List<Turma> turmas = new ArrayList<Turma>();
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Turma turma = new Turma();

				turma.setCodigo(rs.getInt("codigo"));
				turma.setCurso(new CursoDAO().consultar(rs.getInt("codigoCurso")));
				turma.setDataInicio(rs.getDate("dataInicio"));
				turma.setDataFim(rs.getDate("dataTermino"));
				turma.setHoraInicio(rs.getTime("horaInicio"));
				turma.setHoraTermino(rs.getTime("dataTermino"));
				turma.setProfessor(new ProfessorDAO().consultar(rs.getInt("codigo")));
				turma.setTurno(rs.getString("turno").toString().charAt(0));

				turmas.add(turma);
			}

			rs.close();
			stmt.close();
			return turmas;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(Turma turma) {
		String sql = "DELETE FROM Turma WHERE codigo = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, turma.getCodigo());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
