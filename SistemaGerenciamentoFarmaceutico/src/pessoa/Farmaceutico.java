package pessoa ;

import java.time.LocalDate;

public class Farmaceutico extends Funcionario {
	
	// Atributos (private)
	private String crf;
	
	
	// Métodos
	
	// Construtor
	public Farmaceutico(String nome, String cpf, String telefone, String matricula, LocalDate dataAdmissao, String crf) {
		super(nome, cpf, telefone, matricula, dataAdmissao);
		
	}
	
	// Getters e Setters
	public String getCrf() {
		return crf;
	}
	
	public void setCrf(String crf) {
		this.crf = crf;
	}
	
	// podeDispensarControlado()
	
	@Override
	public boolean podeDispensarControlado() {
		return true;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", CRF: " + getCrf() +", Telefone: " + getTelefone() + ", Matrícula: " + getMatricula() + ", Data de admissão: " + getDataAdmissao();
	}
}
