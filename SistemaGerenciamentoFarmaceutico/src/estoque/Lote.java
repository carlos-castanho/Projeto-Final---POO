package estoque;

import java.time.LocalDate;
import java.util.Objects;

import pessoa.Fornecedor;
import produto.Produto;

public class Lote {

	// Atributos (private)
	private String numeroLote;
	private Produto produto;
	private Fornecedor fornecedor;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private int quantidade;

	// Métodos

	// Construtor
	public Lote(String numeroLote, Produto produto, Fornecedor fornecedor, LocalDate dataFabricacao,
			LocalDate dataValidade, int quantidade) {
		this.numeroLote = numeroLote;
		this.produto = produto;
		this.fornecedor = fornecedor;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
	}

	// Getters
	public String getNumeroLote() {
		return numeroLote;
	}

	public Produto getProduto() {
		return produto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	// baixar(int quantidade): reduz a quantidade do lote
	public void baixar(int qtd) {
		if (qtd <= 0) {
			throw new IllegalArgumentException("Quantidade deve ser positiva.");
		}
		if (qtd > quantidade) {
			throw new IllegalArgumentException("Estoque insuficiente no lote " + numeroLote);
		}
		quantidade -= qtd;
	}

	// estaVencido(LocalDate ref) : true -> Vencido  |  false -> Ainda pode vender
	public boolean estaVencido(LocalDate ref) {
		return ref.isAfter(dataValidade);
	}

	// venceAte(LocalDate limite) : utilizado para gerar alertas na versão final do projeto
	public boolean venceAte(LocalDate limite) {
		return !dataValidade.isAfter(limite);
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

		Lote l = (Lote) obj;
		return Objects.equals(numeroLote, l.numeroLote) && Objects.equals(produto, l.produto);
	}

	// hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(numeroLote, produto);
	}

	// toString()
	@Override
	public String toString() {
		return "Lote: " + getNumeroLote() + ", Produto: " + getProduto() + ", Validade: " + getDataValidade() + ", Quantidade: " + getQuantidade();
	}
}
