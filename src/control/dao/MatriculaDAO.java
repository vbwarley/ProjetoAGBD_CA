package control.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Matricula;
import model.Turma;
import control.dao.banco.ConnectionFactory;

public class MatriculaDAO {

	private Connection connection;

	public MatriculaDAO(){

		this.connection = new ConnectionFactory().getConnection();

	}

	public void matricular (Matricula matricula){

		String sql = "INSERT INTO Matricula " +
				"(cpf, codigoTurma, data, valorPago)" +
				" VALUES (?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, matricula.getAluno().getCpf());
			stmt.setInt(2, matricula.getTurma().getCodigo());
			stmt.setDate(3, matricula.getData());
			stmt.setDouble(4, matricula.getValorPago());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<Turma> consultarMatricula(Integer cpfA) {
		
		try {
			List<Turma> turmas = new ArrayList<Turma>();
			
			CallableStatement cs = connection.prepareCall("{call verTurmaAluno(?)}");
			
			cs.setInt(1, cpfA);
			
			cs.executeQuery();
			
			ResultSet rs = cs.getResultSet();
			
			while (rs.next()) {
				Turma turma = new TurmaDAO().consultar(rs.getInt(1));
				turmas.add(turma);
			}
			
			cs.close();
			rs.close();
			return turmas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
