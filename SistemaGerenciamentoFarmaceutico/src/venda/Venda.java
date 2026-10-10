package venda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pessoa.Cliente;
import pessoa.Funcionario;
import receita.Receita;

public class Venda {

	// Atributos (private)
	private static int proximoNumero = 1;
	private int numero;
	private LocalDateTime dataHora;
	private Cliente cliente;
	private Funcionario funcionario;
	private List<ItemVenda> itens = new ArrayList<>();
	private Receita receita;

	// Métodos

	// Construtor
	public Venda(Cliente cliente, Funcionario funcionario) {
		this.numero = proximoNumero++;
		this.dataHora = LocalDateTime.now();
		this.cliente = cliente;
		this.funcionario = funcionario;
	}

	// adicionarItem(ItemVenda item) : adiciona um item na venda
	public void adicionarItem(ItemVenda item) {
		itens.add(item);
	}

	// anexarReceita(Receita receita)
	public void anexarReceita(Receita receita) {
		this.receita = receita;
	}

	// calcularTotal() : calcula o valor final da venda
	public double calcularTotal() {
		double total = 0;
		for (ItemVenda item : itens) {
			total += item.getSubtotal();
		}
		return total;
	}

	// exigeReceita()
	public boolean exigeReceita() {
		for (ItemVenda item : itens) {
			if (item.getProduto().exigeReceita()) {
				return true;
			}
		}
		return false;
	}

	// Getters
	public int getNumero() {
		return numero;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public List<ItemVenda> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public Receita getReceita() {
		return receita;
	}

	// equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Venda outra = (Venda) obj;
		return numero == outra.numero;
	}

	// hashCode()
	@Override
	public int hashCode() {
		return Integer.hashCode(numero);
	}

	// toString()
	@Override
	public String toString() {
		return "Venda: " + numero + ", Data/Hora: " + dataHora + ", Cliente: "
				+ (cliente != null ? cliente.getNome() : "sem cadastro") + ", Funcionário: " + funcionario.getNome()
				+ ", Total: R$ " + calcularTotal();
	}
}