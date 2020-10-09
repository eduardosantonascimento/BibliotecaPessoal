package br.com.eduadoespiritosanto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.eduadoespiritosanto.model.Livro;





public class LivroDAO implements ILivroDAO{

	private final static String INSERIR_LIVRO = "INSERT INTO livros (nome_Livro,nome_Autor,nome_Editora, numero_Edicao, "
													+ "ano_Lancamento, numeroPagina, resumo_Livro, numero_ISBN) "
													+ "VALUES (?,?,?,?,?,?,?,?)";
    private final static String ATUALIZAR_LIVRO = "UPDATE livros SET nome=? , cpf=?, endereco=? WHERE id=?";
    private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  clientes (id int(3) NOT NULL AUTO_INCREMENT   PRIMARY KEY, nome VARCHAR(20) NOT NULL, cpf varchar(20) NOT NULL, telefone varchar(20) NOT NULL)";
    private final static String DELETE_LIVRO = "DELETE FROM clientes WHERE idLivros = '";
    private final static String GET_ALL_LIVRO = "SELECT * FROM livros ";
    private final static String GET_LIVRO_BY_ID = "SELECT * FROM livros WHERE cpf = ?";
    
       
    
	public static void  salvar(Livro livro) throws BibliotecaException {
	
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		        try {
		            conn = ConnectionManager.getConnection();
		            if (livro.getId() == null ) {
		                stmt = conn.prepareStatement(INSERIR_LIVRO);
		            } else {
		                stmt = conn.prepareStatement(ATUALIZAR_LIVRO);
		                stmt.setInt(4, livro.getId());
		            }
		            stmt.setString(1, livro.getNomeLivro());
		            stmt.setString(2, livro.getNomeAutor() );
		            stmt.setString(3, livro.getNomeEditora());
		            stmt.setString(4, livro.getNumeroEdicao());
		            stmt.setString(5, livro.getAnoLancamento());
		            stmt.setString(6, livro.getNumeroPagina());
		            stmt.setString(7, livro.getResumoLivro());
		            stmt.setString(8, livro.getNumeroISBN());
		            
		            stmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally {
		            ConnectionManager.closeAll(conn, stmt);
		        }
		    }
	
	
	
	// Chama um lista de produtos
	
		public static List <Livro> getAllLIVRO() throws SQLException {
			List<Livro> lstEnt = null;
			
			List<Object> param = new ArrayList<>();
					
			ResultSet rs = QUERY(GET_ALL_LIVRO, param);
			
			if(rs.next()) {
				lstEnt = new ArrayList<>();
				do {
					lstEnt.add(MAPPER(rs));
				}while(rs.next());
			}
			return lstEnt;
		}
		
		
		// Testando pra ver se vai
		public static Livro getListaLIVRO() throws SQLException {
			Object lstEnt = null;
			
			List<Object> param = new ArrayList<>();
					
			ResultSet rs = QUERY(GET_ALL_LIVRO, param);
			
			if(rs.next()) {
				lstEnt = new ArrayList<>();
				do 
				{
				   ((List<Livro>) lstEnt).add(MAPPER(rs));
				}
				while
				(
				rs.next()
				);
			}
			
			
			return lstEnt;
		}
	
	
	
	
	public static void PARAM(PreparedStatement stmt, List<Object> param) throws SQLException{
		
		int index=1;
		
		for (Object o: param) {
			if(o instanceof String) stmt.setString(index,(String) o);
			if(o instanceof Integer) stmt.setInt(index,(Integer) o);
			if(o instanceof Double) stmt.setDouble(index,(Double) o);
			
			index++;
		}
		
	}
	
	

	//R - Read   - SELECT
		private static ResultSet QUERY(String sql, List<Object> param) throws SQLException{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			PARAM(stmt, param);
			
			ResultSet rs = stmt.executeQuery();
			return rs;
		}
	
	// MAPPER - Mapear os produtos
		private static Livro MAPPER (ResultSet rs) throws SQLException{
			
			Livro ent = new Livro();
			ent = new Livro();
			ent.setNomeLivro(			rs.getString("nome_Livro")			);
			ent.setNomeAutor(		rs.getString("nome_Autor")	);
			ent.setNomeEditora(		rs.getString("nome_Editora")	);
			ent.setNumeroPagina(		rs.getString("numeroPagina")	);
			
			
			return ent;
		}
		
			
}


