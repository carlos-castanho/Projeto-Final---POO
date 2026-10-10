package estoque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {
	
	// Atributos (private)
	private Map<String, List<Lote>> lotesPorProduto = new HashMap<String, List<Lote>>();
	private Map<String, Integer> estoqueMinimo = new HashMap<String, Integer>();

	// adicionarLote(Lote lote) : Entrada de mercadoria (Descobre o código do produto de um determinado lote)
	public void adicionarLote(Lote lote) {
		String codigo = lote.getProduto().getCodigo();
		lotesPorProduto.putIfAbsent(codigo, new ArrayList<>());
		lotesPorProduto.get(codigo).add(lote);
	}

	// definirEstoqueMinimo(String codigo, int minimo) : Define o mínimo de um produto
	public void definirEstoqueMinimo(String codigo, int minimo) {
		estoqueMinimo.put(codigo, minimo);
	}

	// quantidadeDisponivel(String codigo) : quanto dá para vender (soma apenas os lotes que não estão vencidos)
	public int quantidadeDisponivel(String codigo) {
		int total = 0;
		LocalDate hoje = LocalDate.now();
		for (Lote lote : lotesPorProduto.getOrDefault(codigo, new ArrayList<>())) {
			if (!lote.estaVencido(hoje)) {
				total += lote.getQuantidade();
			}
		}
		return total;
	}

	// selecionarLotesFEFO(String codigo, int qtd) : Escolhe de quais lotes tirar, começando pelo que vence primeiro
	public List<Lote> selecionarLotesFEFO(String codigo, int qtd) {
		if (quantidadeDisponivel(codigo) < qtd) {
			throw new IllegalArgumentException("Estoque insuficiente para o produto " + codigo);
		}

		// Pega só os lotes que não estão vencidos e com unidades
		List<Lote> validos = new ArrayList<>();
		LocalDate hoje = LocalDate.now();
		for (Lote lote : lotesPorProduto.get(codigo)) {
			if (!lote.estaVencido(hoje) && lote.getQuantidade() > 0) {
				validos.add(lote);
			}
		}

		// Ordena pela data de validade (o mais próximo de vencer primeiro)
		validos.sort(Comparator.comparing(Lote::getDataValidade));

		// Vai pegando lotes até cobrir a quantidade pedida
		List<Lote> selecionados = new ArrayList<>();
		int falta = qtd;
		for (Lote lote : validos) {
			if (falta <= 0)
				break;
			selecionados.add(lote);
			falta -= lote.getQuantidade();
		}
		return selecionados;
	}

	// baixar(String codigo, int qtd) : Dá baixa, tirando dos lotes escolhidos pelo FEFO
	public void baixar(String codigo, int qtd) {
		List<Lote> lotes = selecionarLotesFEFO(codigo, qtd);
		int falta = qtd;
		for (Lote lote : lotes) {
			int tirar = Math.min(falta, lote.getQuantidade());
			lote.baixar(tirar);
			falta -= tirar;
		}
	}

	// produtosAbaixoDoMinimo() : Códigos dos produtos com quantidade menor que o mínimo definido previamente
	public List<String> produtosAbaixoDoMinimo() {
		List<String> resultado = new ArrayList<>();
		for (Map.Entry<String, Integer> entrada : estoqueMinimo.entrySet()) {
			String codigo = entrada.getKey();
			int minimo = entrada.getValue();
			if (quantidadeDisponivel(codigo) < minimo) {
				resultado.add(codigo);
			}
		}
		return resultado;
	}

	// lotesVencendoAte(LocalDate limite) : Todos os lotes com unidades que vencem até a data limite
	public List<Lote> lotesVencendoAte(LocalDate limite) {
		List<Lote> resultado = new ArrayList<>();
		for (List<Lote> lotes : lotesPorProduto.values()) {
			for (Lote lote : lotes) {
				if (lote.getQuantidade() > 0 && lote.venceAte(limite)) {
					resultado.add(lote);
				}
			}
		}
		return resultado;
	}
}