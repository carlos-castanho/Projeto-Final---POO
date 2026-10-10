package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import estoque.Estoque;
import pessoa.Cliente;
import pessoa.Funcionario;
import produto.Medicamento;
import produto.Produto;
import venda.ItemVenda;
import venda.Venda;

public class Farmacia {

	// Atributos (private)
	private final List<Produto> produtos = new ArrayList<>();
	private final List<Cliente> clientes = new ArrayList<>();
	private final List<Funcionario> funcionarios = new ArrayList<>();
	private final List<Venda> vendas = new ArrayList<>();
	private final Estoque estoque = new Estoque();

	// Métodos

	// cadastrarProduto(Produto p) : impede produto com código repetido
	public void cadastrarProduto(Produto p) {
		if (produtos.contains(p)) {
			throw new IllegalArgumentException("Já existe produto com o código " + p.getCodigo());
		}
		produtos.add(p);
	}

	// cadastrarCliente(Cliente c) : impede cliente com CPF repetido
	public void cadastrarCliente(Cliente c) {
		if (clientes.contains(c)) {
			throw new IllegalArgumentException("Já existe cliente com o CPF " + c.getCpf());
		}
		clientes.add(c);
	}

	// cadastrarFuncionario(Funcionario f) : impede funcionário com CPF repetido
	public void cadastrarFuncionario(Funcionario f) {
		if (funcionarios.contains(f)) {
			throw new IllegalArgumentException("Já existe funcionário com o CPF " + f.getCpf());
		}
		funcionarios.add(f);
	}

	// buscarProduto(String codigo) : retorna o produto ou null se não existir
	public Produto buscarProduto(String codigo) {
		for (Produto p : produtos) {
			if (p.getCodigo().equals(codigo)) {
				return p;
			}
		}
		return null;
	}

	// finalizarVenda(Venda venda) : aplica todas as regras antes de concluir a venda
	public void finalizarVenda(Venda venda) {
		if (venda.getItens().isEmpty()) {
			throw new IllegalStateException("A venda não tem itens.");
		}

		// Regras de receita
		if (venda.exigeReceita()) {
			if (venda.getReceita() == null) {
				throw new IllegalStateException("Esta venda exige receita.");
			}
			if (!venda.getReceita().validar(LocalDate.now())) {
				throw new IllegalStateException("A receita está vencida.");
			}
			for (ItemVenda item : venda.getItens()) {
				Produto p = item.getProduto();
				if (p.exigeReceita() && !venda.getReceita().prescreve((Medicamento) p)) {
					throw new IllegalStateException(p.getNome() + " não consta na receita.");
				}
			}
			if (!venda.getFuncionario().podeDispensarControlado()) {
				throw new IllegalStateException("Este funcionário não pode dispensar medicamento com receita.");
			}
		}

		// Confere o estoque de todos os itens antes de baixar qualquer um
		for (ItemVenda item : venda.getItens()) {
			String codigo = item.getProduto().getCodigo();
			if (estoque.quantidadeDisponivel(codigo) < item.getQuantidade()) {
				throw new IllegalStateException("Estoque insuficiente: " + item.getProduto().getNome());
			}
		}

		// Baixa o estoque FEFO e registra a venda
		for (ItemVenda item : venda.getItens()) {
			estoque.baixar(item.getProduto().getCodigo(), item.getQuantidade());
		}
		vendas.add(venda);
	}

	// Getters
	public Estoque getEstoque() {
		return estoque;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public List<Cliente> getClientes() {
		return Collections.unmodifiableList(clientes);
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(funcionarios);
	}

	public List<Venda> getVendas() {
		return Collections.unmodifiableList(vendas);
	}
}
