package pessoa;

import java.time.LocalDate;

public class Atendente extends Funcionario {
	
	// Métodos
	
	// Construtor
	public Atendente(String nome, String cpf, String telefone, LocalDate dataAdmissao) {
		super(nome, cpf, telefone, dataAdmissao);
	}

	// podeDispensarControlado()
	@Override
	public boolean podeDispensarControlado() {
		return false;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() + ", Matrícula: " + getMatricula() + ", Data de admissao: " + getDataAdmissao();
	}
}
