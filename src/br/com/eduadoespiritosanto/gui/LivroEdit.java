package br.com.eduadoespiritosanto.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
	
	
	
	
	public LivroEdit()  {
		setTitle("Livro Edit");
		setSize(800, 800);
		setLayout(new BorderLayout(2,2));
		add(panelFormulario(),BorderLayout.CENTER);
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

private JPanel panelBotoes() {
	
			
	JPanel p = new JPanel();
	p.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	
	JButton b1 = new JButton("Salvar");
	b1.setMnemonic('S');
	b1.addMouseListener(new SalvarClienteListener());
	p.add(b1);
	
		
	
	return p;

}

private Livro loadClienteFromPanel() throws BibliotecaException {
	System.out.println("Salvando os dados do Cliente");
	String nome = tfNomeLivro.getText();
	String endereco = tfNomeEditora.getText();
	String cpf = tfNomeAutor.getText();
	String strId = null;
	int id = 0;
	if ((strId != null) && (strId.length() > 0)) {
		 id = Integer.parseInt(strId);
	}
	Livro livroAtual = new Livro(id, nome, cpf, endereco );
	return livroAtual;
}



class SalvarClienteListener extends MouseAdapter {

	public void mouseClicked(MouseEvent arg0) {
		Livro livro = null;
		try {
			livro = loadClienteFromPanel();
			System.out.println(livro);

			// c) Salva o livro lido da tela no banco de dados
			ILivroDAO dao = new LivroDAO();
			dao.salvar(livro);
			//cbClientes.reloadFromDatabase();
			
		} catch (BibliotecaException e) {
			e.printStackTrace();
		}

	}
}


public static void main (String[] args) {
	
	LivroEdit f = new LivroEdit();
}

}
