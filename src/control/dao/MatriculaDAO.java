package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Matricula;
import control.dao.banco.ConnectionFactory;

public class MatriculaDAO {

	private Connection connection;

	public MatriculaDAO(){

		this.connection = new ConnectionFactory().getConnection();

	}

	public void matricular (Matricula matricula){

		String sql = "INSERT INTO Matricula " +
				"(cpf, codigo, data, valorPago)" +
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

}
