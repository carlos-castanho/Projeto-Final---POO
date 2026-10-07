package produto;

import java.util.Objects;

public abstract class Produto {

	// Atributos (private)
	private String codigo;
	private String nome;
	private double preco;
	private String fabricante;

	// Métodos

	// Construtor
	public Produto(String codigo, String nome, double preco, String fabricante) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.fabricante = fabricante;
	}

	// Getters e Setters
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	// equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Produto p = (Produto) obj;
		return Objects.equals(codigo, p.codigo);
	}

	// hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	// toString()
	@Override
	public String toString() {
		return "Código: " + getCodigo() + "Nome: " + getNome() + ", Preço: R$" + getPreco() + ", Fabricante: " + getFabricante();
	}
	
	// exigeReceita() : define se o produto exige receita para ser comercializado
	public abstract boolean exigeReceita();
}
