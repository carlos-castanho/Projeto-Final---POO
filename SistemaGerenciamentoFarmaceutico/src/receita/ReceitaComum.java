package receita;

import java.time.LocalDate;
import pessoa.Cliente;

public class ReceitaComum extends Receita {

	// Métodos

	// Construtor
	public ReceitaComum(String medicoPrescritor, String crm, String ufCrm, LocalDate dataEmissao, Cliente paciente) {
		super(medicoPrescritor, crm, ufCrm, dataEmissao, paciente);
	}

	// getPrazoValidadeDias()
	@Override
	public int getPrazoValidadeDias() {
		return 180;
	}

	// exigeRetencao
	@Override
	public boolean exigeRetencao() {
		return false;
	}
}