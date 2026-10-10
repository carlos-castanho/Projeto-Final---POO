package pessoa;

import java.time.*;

public class Cliente extends Pessoa{
	
	// Atributos (private)
	private LocalDate dataCadastro;
	
	
	// Métodos
	
	// Construtor 
	public Cliente(String nome, String cpf, String telefone, LocalDate dataCadastro) {
		super(nome, cpf, telefone);
		this.dataCadastro = dataCadastro;
	}
	
	// Getters e Setters
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() + ", Data do cadastro: " + getDataCadastro();
	}
}
