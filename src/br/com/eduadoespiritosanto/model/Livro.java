package br.com.eduadoespiritosanto.model;

public class Livro {
	
	String nomeLivro;
	String nomeAutor;
	String nomeEditora;
	String numeroEdicao;
	String anoLancamento;
	String numeroPagina;
	String resumoLivro;
	String numeroISBN;
	Integer id;
	
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getNomeEditora() {
		return nomeEditora;
	}
	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	public String getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(String numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	public String getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(String numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
	public String getResumoLivro() {
		return resumoLivro;
	}
	public void setResumoLivro(String resumoLivro) {
		this.resumoLivro = resumoLivro;
	}
	public String getNumeroISBN() {
		return numeroISBN;
	}
	public void setNumeroISBN(String numeroISBN) {
		this.numeroISBN = numeroISBN;
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Livro(String nomeLivro, String nomeAutor, String nomeEditora, String numeroEdicao, String anoLancamento,
			String numeroPagina, String resumoLivro, String numeroISBN) {
		super();
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.nomeEditora = nomeEditora;
		this.numeroEdicao = numeroEdicao;
		this.anoLancamento = anoLancamento;
		this.numeroPagina = numeroPagina;
		this.resumoLivro = resumoLivro;
		this.numeroISBN = numeroISBN;
	}
	
	public Livro() {
		
	}
	
	@Override
	public String toString() {
		return "Livro [nomeLivro=" + nomeLivro + ", nomeAutor=" + nomeAutor + ", nomeEditora=" + nomeEditora
				+ ", numeroEdicao=" + numeroEdicao + ", anoLancamento=" + anoLancamento + ", numeroPagina="
				+ numeroPagina + ", resumoLivro=" + resumoLivro + ", numeroISBN=" + numeroISBN + "]";
	}
	
	
	

}
