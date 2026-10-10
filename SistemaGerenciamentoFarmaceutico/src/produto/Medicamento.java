package produto;

public abstract class Medicamento extends Produto {

	// Atributos (private)
	private String principioAtivo;
	private String dosagem;
	private String registroAnvisa;

	// Métodos

	// Construtor
	public Medicamento(String codigo, String nome, double preco, String fabricante, String principioAtivo,
			String dosagem, String registroAnvisa) {
		super(codigo, nome, preco, fabricante);
		this.principioAtivo = principioAtivo;
		this.dosagem = dosagem;
		this.registroAnvisa = registroAnvisa;
	}

	// Getters e Setters
	public String getPrincipioAtivo() {
		return principioAtivo;
	}

	public void setPrincipioAtivo(String principioAtivo) {
		this.principioAtivo = principioAtivo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getRegistroAnvisa() {
		return registroAnvisa;
	}

	public void setRegistroAnvisa(String registroAnvisa) {
		this.registroAnvisa = registroAnvisa;
	}

	// toString()
	@Override
	public String toString() {
		return "Código: " + getCodigo() + ", Nome: " + getNome() + ", Preço: R$" + getPreco() + ", Fabricante: "
				+ getFabricante() + ", Principio Ativo: " + getPrincipioAtivo() + ", Dosagem: " + getDosagem()
				+ ", Registro Anvisa: " + getRegistroAnvisa();
	}
}
