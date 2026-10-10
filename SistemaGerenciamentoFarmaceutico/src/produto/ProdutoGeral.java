package produto;

public class ProdutoGeral extends Produto{
	
	// Atributos (private)
	private String categoria;
	
	
	// Métodos
	
	// Construtor
	public ProdutoGeral (String codigo, String nome, double preco, String fabricante, String categoria) {
		super(codigo, nome, preco, fabricante);
		this.categoria = categoria;
	}
	
	// Getters e Setters
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	// toString()
	@Override
		public String toString() {
			return "Código: " + getCodigo() + ", Nome: " + getNome() + ", Categoria: " + getCategoria() + ", Preço: R$" + getPreco() + ", Fabricante: " + getFabricante();
		}
	
	// exigeReceita()
	@Override
	public boolean exigeReceita() {
		return false;
	}
}
