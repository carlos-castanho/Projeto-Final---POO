package receita;

import java.time.LocalDate;
import pessoa.Cliente;

public class ReceitaControleEspecial extends Receita {

	// Atributos (private)
	private String numeroNotificacao;

	// Métodos

	// Construtor
	public ReceitaControleEspecial(String medicoPrescritor, String crm, String ufCrm, LocalDate dataEmissao,
			Cliente paciente, String numeroNotificacao) {
		super(medicoPrescritor, crm, ufCrm, dataEmissao, paciente);
		this.numeroNotificacao = numeroNotificacao;
	}

	// getNumeroNotificacao
	public String getNumeroNotificacao() {
		return numeroNotificacao;
	}

	// getPrazoValidadeDias
	@Override
	public int getPrazoValidadeDias() {
		return 30;
	}

	// exigeRetencao
	@Override
	public boolean exigeRetencao() {
		return true;
	}

	// toString()
	@Override
	public String toString() {
		return super.toString() + ", Notificação: " + numeroNotificacao;
	}
}