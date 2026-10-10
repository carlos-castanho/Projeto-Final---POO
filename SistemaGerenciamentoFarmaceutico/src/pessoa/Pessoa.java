package pessoa;

import java.util.Objects;

public abstract class Pessoa {
	
	// Atributos (Private) 
	private String nome;
	private String cpf;
	private String telefone;
	
	// Métodos
	
	// Construtor 
	public Pessoa(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	// equals()
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Pessoa p = (Pessoa) obj;
		return Objects.equals(cpf, p.cpf);
	}
	
	// hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	// toString()
	@Override
	public String toString() {
		return "Nome: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone();
	}
}
