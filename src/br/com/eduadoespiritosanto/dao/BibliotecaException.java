package br.com.eduadoespiritosanto.dao;

public class BibliotecaException extends Exception {
	
	public BibliotecaException(String mensagem, Exception e) {
		super(mensagem, e);
	}

	public BibliotecaException(String mensagem) {
		super(mensagem);
	}

}
