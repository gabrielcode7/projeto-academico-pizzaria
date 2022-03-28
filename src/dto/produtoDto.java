package dto;

public class produtoDto {
	
	private String nome_do_produto;
	private String codigo_de_barras;
	private String estoque_unitario;
	private String tamanho;
	private String valor_de_venda;
	
	public String getNome_do_produto() {
		return nome_do_produto;
	}
	public void setNome_do_produto(String nome_do_produto) {
		this.nome_do_produto = nome_do_produto;
	}
	public String getCodigo_de_barras() {
		return codigo_de_barras;
	}
	public void setCodigo_de_barras(String codigo_de_barras) {
		this.codigo_de_barras = codigo_de_barras;
	}
	public String getEstoque_unitario() {
		return estoque_unitario;
	}
	public void setEstoque_unitario(String estoque_unitario) {
		this.estoque_unitario = estoque_unitario;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getValor_de_venda() {
		return valor_de_venda;
	}
	public void setValor_de_venda(String valor_de_venda) {
		this.valor_de_venda = valor_de_venda;
	}
	

}
