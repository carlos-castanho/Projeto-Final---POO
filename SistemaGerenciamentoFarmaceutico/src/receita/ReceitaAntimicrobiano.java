package receita;

import java.time.LocalDate;

import pessoa.Cliente;

public class ReceitaAntimicrobiano extends Receita {

	// Métodos

	// Construtor
	public ReceitaAntimicrobiano(String medicoPrescritor, String crm, String ufCrm, LocalDate dataEmissao,
			Cliente paciente) {
		super(medicoPrescritor, crm, ufCrm, dataEmissao, paciente);
	}

	// getPrazoValidadeDias()
	@Override
	public int getPrazoValidadeDias() {
		return 10;
	}

	// exigeRetencao
	@Override
	public boolean exigeRetencao() {
		return true;
	}
}
