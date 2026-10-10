package produto;

public class MedicamentoControlado extends Medicamento {

	// Atributos (private)
	private ListaControle lista;

	// Métodos

	// Construtor
	public MedicamentoControlado(String codigo, String nome, double preco, String fabricante, String principioAtivo,
			String dosagem, String registroAnvisa, ListaControle lista) {
		super(codigo, nome, preco, fabricante, principioAtivo, dosagem, registroAnvisa);
		this.lista = lista;
	}

	// Getter
	public ListaControle getLista() {
		return lista;
	}

	// exigeReceita()
	@Override
	public boolean exigeReceita() {
		return true;
	}

	// toString()
	@Override
	public String toString() {
		return super.toString() + ", Lista: " + lista;
	}
}
