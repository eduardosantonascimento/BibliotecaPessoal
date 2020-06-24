package br.com.eduadoespiritosanto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.eduadoespiritosanto.model.Livro;



public class LivroDAO implements ILivroDAO{

	private final static String INSERIR_LIVRO = "INSERT INTO livros (nome,cpf,endereco) VALUES (?,?,?)";
    private final static String ATUALIZAR_LIVRO = "UPDATE livros SET nome=? , cpf=?, endereco=? WHERE id=?";
    private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  clientes (id int(3) NOT NULL AUTO_INCREMENT   PRIMARY KEY, nome VARCHAR(20) NOT NULL, cpf varchar(20) NOT NULL, telefone varchar(20) NOT NULL)";
    private final static String DELETE_LIVRO = "DELETE FROM clientes WHERE cpf = '";
    private final static String GET_ALL_LIVRO = "SELECT * FROM livros";
    private final static String GET_LIVRO_BY_ID = "SELECT * FROM livros WHERE cpf = ?";
    
    
	public void salvar(Livro livro) throws BibliotecaException {
		        
		
		Connection conn = null;
		PreparedStatement stmt = null;
		        try {
		            conn = ConnectionManager.getConnection();
		            if (cliente.getId() == 0) {
		                stmt = conn.prepareStatement(INSERIR_LIVRO);
		            } else {
		                stmt = conn.prepareStatement(ATUALIZAR_LIVRO);
		                stmt.setInt(4, cliente.getId());
		            }
		            stmt.setString(1, cliente.getNome());
		            stmt.setString(2, cliente.getCpf());
		            stmt.setString(3, cliente.getEndereco());
		            stmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            ConnectionManager.closeAll(conn, stmt);
		        }
		    }
	
	
}



	
