package produto;

public class MedicamentoComum extends Medicamento {

	// Atributos (private)
	private boolean tarjaVermelha;

	// Métodos

	// Construtor
	public MedicamentoComum(String codigo, String nome, double preco, String fabricante, String principioAtivo,
			String dosagem, String registroAnvisa, boolean tarjaVermelha) {
		super(codigo, nome, preco, fabricante, principioAtivo, dosagem, registroAnvisa);
		this.tarjaVermelha = tarjaVermelha;
	}

	// Getters e Setters
	public boolean getTarjaVermelha() {
		return tarjaVermelha;
	}

	public void setTarjaVermelha(boolean tarjaVermelha) {
		this.tarjaVermelha = tarjaVermelha;
	}

	// exigeReceita()
	@Override
	public boolean exigeReceita() {
		return tarjaVermelha;
	}

	// toString()
	@Override
	public String toString() {
	    String tarja;
	    if (tarjaVermelha) {
	        tarja = "sim";
	    } else {
	        tarja = "não";
	    }
	    return super.toString() + ", Tarja vermelha: " + tarja;
	}
}
