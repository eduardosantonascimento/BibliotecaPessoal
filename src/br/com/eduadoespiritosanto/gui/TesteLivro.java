package br.com.eduadoespiritosanto.gui;

import java.sql.SQLException;
import java.util.List;

import br.com.eduadoespiritosanto.dao.LivroDAO;
import br.com.eduadoespiritosanto.model.Livro;


public class TesteLivro {
	
	public static void main(String[] args) {
		
		try {
			
			List<Livro> lst = LivroDAO.getAllLIVRO(); 		//cria a lista baseada no getAll
			for (Livro livro : lst) {
				System.out.println(livro);         				// imprime a lista criada
			}
			
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}



