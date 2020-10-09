package br.com.eduadoespiritosanto.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import br.com.eduadoespiritosanto.dao.BibliotecaException;
import br.com.eduadoespiritosanto.dao.ILivroDAO;
import br.com.eduadoespiritosanto.dao.LivroDAO;
import br.com.eduadoespiritosanto.model.Livro;


public class LivroEdit extends JFrame {
	
	
	private JTextField tfNomeLivro;
	private JTextField tfNomeAutor;
	private JTextField tfNomeEditora;
	private JTextField tfNumeroEdicao;
	private JTextField tfAnoLancamento;
	private JTextField tfNumeroPagina;
	private JTextField tfResumoLivro;
	private JTextField tfNumeroISBN;
	
	
	
	 //headers for the table
    String[] columns = new String[] {
        "Id", "Livro", "Autor", "Editora"
    };
     
    //actual data for the table in a 2d array
    Object[][] data = new Object[][] {
        {1, "John", 40.0, false },
        {2, "Rambo", 70.0, false },
        {3, "Zorro", 60.0, true },
         };
         
      
   
	
   	
	
	public LivroEdit()  {
		setTitle("Livro Edit");
		setSize(800, 800);
		setLayout(new BorderLayout(2,2));
		add(panelFormulario(),BorderLayout.NORTH);
		add(tabelaLivros(),BorderLayout.CENTER);
		add(panelBotoes(), BorderLayout.SOUTH);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
private JPanel panelFormulario() {
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(16,1, 5, 5));
		
		p.add(new JLabel("ID"));
		JTextField t1 = new JTextField("", 10);
		t1.setEditable(false);
		p.add(t1);
		
		
		p.add(new JLabel("Nome do livro"));
		p.add(tfNomeLivro = new JTextField("", 10));
		
		p.add(new JLabel("Nome do Autor(a) :"));
		p.add(tfNomeAutor = new JTextField("", 10));
		
		p.add(new JLabel("Nome da Editora"));
		p.add(tfNomeEditora = new JTextField("", 10));
		
		p.add(new JLabel("Numero da Edição"));
		p.add(tfNumeroEdicao = new JTextField("", 10));
		
		p.add(new JLabel("Ano de lançamento"));
		p.add(tfAnoLancamento = new JTextField("", 10));
		
		p.add(new JLabel("Quantidade de Páginas"));
		p.add(tfNumeroPagina = new JTextField("", 10));
		
		p.add(new JLabel("Escreva um breve resumo do livro"));
		p.add(tfResumoLivro = new JTextField("", 10));
		
		p.add(new JLabel("Numero do ISBN"));
		p.add(tfNumeroISBN = new JTextField("", 10));
		
		
		
		
		return p;
	}

private JPanel tabelaLivros() {
	
	JPanel p = new JPanel();
	p.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	
	JTable table = ListarLivro(); //new JTable(data, columns);
	
	p.add(table);
	p.add(new JScrollPane(table));
	
	
	
	return p;
}


private JPanel panelBotoes() {
	
			
	JPanel p = new JPanel();
	p.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	
	JButton b1 = new JButton("Salvar");
	b1.setMnemonic('S');
	b1.addMouseListener(new SalvarLivroListener());
	p.add(b1);
	
	JButton b2 = new JButton("Limpar");
	b2.setMnemonic('L');
	b2.addMouseListener(new LimparLivroListener());
	p.add(b2);
	
	JButton b3 = new JButton("Exibir");
	b3.setMnemonic('E');
	b3.addMouseListener(new ExibirLivroListener());
	p.add(b3);
	
	return p;

}

private Livro loadLivroFromPanel() throws BibliotecaException {
	System.out.println("Salvando os dados do Livro");
	
	String livro = tfNomeLivro.getText();
	String autor = tfNomeAutor.getText();
	String editora = tfNomeEditora.getText();
	String edicao = tfNumeroEdicao.getText();
	String lancamento = tfAnoLancamento.getText();
	String nPaginas = tfNumeroPagina.getText();
	String resumo = tfResumoLivro.getText();
	String cod_ISBN = tfNumeroISBN.getText();
	String strId = "";
	
	int id = 0;
	if ((strId != null) && (strId.length() > 0)) {
		 id = Integer.parseInt(strId);
	}
	Livro livroAtual = new Livro(livro, autor, editora, edicao, lancamento, nPaginas, resumo, cod_ISBN );
	
	return livroAtual;
}




class SalvarLivroListener extends MouseAdapter {

	public void mouseClicked(MouseEvent arg0) {
		Livro livro = null;
		try {
			livro = loadLivroFromPanel();
			System.out.println(livro);

			// c) Salva o livro lido da tela no banco de dados
			ILivroDAO dao = new LivroDAO();
			LivroDAO.salvar(livro);
			//cbClientes.reloadFromDatabase();
			
						
			clearLivroFromPanel();
			
			JOptionPane.showMessageDialog(null, "Seu livro foi salvo");//Alert 
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}
		
		
	}
}

class LimparLivroListener extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		clearLivroFromPanel();
	}
}

class ExibirLivroListener extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		//ListarLivro();
		tabelaLivros();
		
	}
}

private void clearLivroFromPanel() {
	System.out.println("Limpando o painel de cadastro de clientes");
	this.tfNomeLivro.setText("");
	this.tfNomeAutor.setText("");
	this.tfNomeEditora.setText("");
	this.tfNumeroEdicao.setText("");
	this.tfAnoLancamento.setText("");
	this.tfNumeroPagina.setText("");
	this.tfResumoLivro.setText("");
	this.tfNumeroISBN.setText("");
}


	private JTable ListarLivro() 
	{
	   
	   DefaultTableModel model;
	   model = new DefaultTableModel(); 
	   JTable jTable1 = new  JTable(model);	   
	   try 
	   {
		
		 List<Livro> lst = LivroDAO.getAllLIVRO(); 		//cria a lista baseada no getAll
		
  
		 model.addColumn("id");
		 model.addColumn("nomeLivro");
		 model.addColumn("nomeAutor");
		 model.addColumn("nomeEditora");
		 model.addColumn("codBarras");
		
		 for(Livro item : lst)
		 {
		    Integer id = item.getId();
		    String nomeLivro = item.getNomeLivro();
		    String nomeAutor = item.getNomeAutor();
		    String nomeEditora = item.getNomeEditora(); 
		    String codBarras = item.getNumeroPagina(); 
		    
		    model.addRow(new Object[]{id, nomeLivro, nomeAutor, nomeEditora,codBarras});
          }
		
		  /*for (Livro livro : lst) 
		  {
			System.out.println(livro);         				// imprime a lista criada
		  }*/
		
	    }
	    catch(SQLException ex) 
	   {
	     ex.printStackTrace();
	   }  
	   
	   return jTable1;
	}

public static void main (String[] args) {
	
	LivroEdit f = new LivroEdit();
}

}
