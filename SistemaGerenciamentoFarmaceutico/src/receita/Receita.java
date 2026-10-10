package receita;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

import pessoa.Cliente;
import produto.Medicamento;


public abstract class Receita implements Validavel {

	// Atributos (private)
	private String medicoPrescritor;
	private String crm;
	private String ufCrm;
	private LocalDate dataEmissao;
	private Cliente paciente;
	private Map<Medicamento, Integer> itens = new HashMap<Medicamento, Integer>();

	// Métodos

	// Construtor
	public Receita(String medicoPrescritor, String crm, String ufCrm, LocalDate dataEmissao, Cliente paciente) {
		this.medicoPrescritor = medicoPrescritor;
		this.crm = crm;
		this.ufCrm = ufCrm;
		this.dataEmissao = dataEmissao;
		this.paciente = paciente;
	}

	// Getters
	public String getMedicoPrescritor() {
		return medicoPrescritor;
	}

	public String getCrm() {
		return crm;
	}

	public String getUfCrm() {
		return ufCrm;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public Cliente getPaciente() {
		return paciente;
	}
	
	// getItens(): tabela de medicamentos da receita, sem permitir alterações
	public Map<Medicamento, Integer> getItens() {
		return Collections.unmodifiableMap(itens);
	}
	
	// adicionarItem(Medicamento m, int quantidade): Adicionar itens à receita
	public void adicionarItem(Medicamento m, int quantidade) {
        itens.put(m, quantidade);
    }

	// validar(LocalDate dataReferencia) : true -> válida  |  false -> inválida
	public boolean validar(LocalDate dataReferencia) {
		LocalDate vencimento = dataEmissao.plusDays(getPrazoValidadeDias());
		return !dataReferencia.isAfter(vencimento);
	}
	
	// getPrazoValidadeDias()
	public abstract int getPrazoValidadeDias();

	// exigeRetencao()
	public abstract boolean exigeRetencao();

	// prescreve(medicamento m): verifica se um medicamento está na receita (true -> está  |  false -> não está)
	public boolean prescreve(Medicamento m) {
		return itens.containsKey(m);
	}
	
	// toString()
	@Override
	public String toString() {
		return "Médico Prescritor: " + getMedicoPrescritor() + ", CRM: " + getCrm() + ", UF CRM: " + getUfCrm() + ", Data de emissão: " + getDataEmissao() + ", Paciente: " + getPaciente();
	}
}