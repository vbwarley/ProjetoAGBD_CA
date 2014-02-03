package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Telefone;
import control.dao.banco.ConnectionFactory;

public class TelefoneDAO {
	
	private Connection connection;
	
	public TelefoneDAO() {
	
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void cadastrar(List<Telefone> telefone, int cpf) {
		String sql = "INSERT INTO Telefone " +
				"(ddd, numero, tipo, cpf)" +
				" VALUES (?,?,?,?)";
		
		for(int i = 0; i < telefone.size(); i++){
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, telefone.get(i).getDdd());
			stmt.setInt(2, telefone.get(i).getNumero());
			stmt.setString(3, telefone.get(i).getTipo());
			stmt.setInt(4, telefone.get(i).getCpf());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		}
	}
	
	// nao testado
			public List<Telefone> consultar(int cpf) {
				String sql = "SELECT * FROM Telefone WHERE cpf = ?";
				
				try {
					List<Telefone> telefones = new ArrayList<Telefone>();
					PreparedStatement stmt = connection.prepareStatement(sql);

					stmt.setInt(1, cpf);
					
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) { //Lembrar de alterar o Telefone

						Telefone telefone = new Telefone(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
						telefones.add(telefone);
					}

					rs.close();
					stmt.close();
					return telefones;			
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

}
