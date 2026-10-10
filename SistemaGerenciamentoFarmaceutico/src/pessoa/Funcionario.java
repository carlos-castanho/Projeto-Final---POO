package pessoa;

import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {
	
	// Atributos (private)
	private String matricula;
	private LocalDate dataAdmissao;
	
	
	// Métodos
	
	// Construtor
	public Funcionario(String nome, String cpf, String telefone, String matricula, LocalDate dataAdmissao) {
		super(nome, cpf, telefone);
		this.matricula = matricula;
		this.dataAdmissao = dataAdmissao;
	}

	// Getters e Setters
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	// podeDispensarControlado() : define o nível de hierarquia do funcionário (se pode ou não vender medicamentos controlados)
	public abstract boolean podeDispensarControlado();

	
	// toString()
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() + ", Matrícula: " + getMatricula() + ", Data de admissão: " + getDataAdmissao();
	}
}
