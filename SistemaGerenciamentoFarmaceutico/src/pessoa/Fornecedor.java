package pessoa;

import java.util.Objects;

public class Fornecedor {

	// Atributos (private)
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private int prazoEntregaDias;

	// Métodos

	// Construtor
	public Fornecedor(String razaoSocial, String cnpj, String telefone, int prazoEntregaDias) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.prazoEntregaDias = prazoEntregaDias;
	}

	// Getters e Setters
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getPrazoEntregaDias() {
		return prazoEntregaDias;
	}
	
	public void setPrazoEntregaDias(int prazoEntregaDias) {
		this.prazoEntregaDias = prazoEntregaDias;
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

		Fornecedor f = (Fornecedor) obj;
		return Objects.equals(cnpj, f.cnpj);
	}

	// hashCode()
	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	// toString()
	@Override
	public String toString() {
		return "Fornecedor (Razão Social): " + getRazaoSocial() + ", CNPJ: " + getCnpj() + ", Telefone: " + getTelefone() + ", Prazo de entrega (dias): " + getPrazoEntregaDias();
	}

}
