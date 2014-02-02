package Negocios;

import java.util.ArrayList;

public class Fachada {
	private static Fachada instance = new Fachada();
	
	public Fachada() {
		
	}
	
	public static Fachada getInstance() {
		return instance;
	}

	public void cadastrarCurso(String nome, String descricao, Double valor,
			Integer limite) {
		// TODO Auto-generated method stub
		
	}

	public boolean consultarCurso(Integer codigo) {
		// TODO Auto-generated method stub
		return true;
	}

	public void alterarCurso(Integer codigo, String nome, String descricao,
			Double valor, Integer limite) {
		// TODO Auto-generated method stub
		
	}

	public String consultarCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluirCurso(Integer codigo) {
		// TODO Auto-generated method stub
		
	}
}
