package venda;

import produto.Produto;

public class ItemVenda {
	
	// Atributos (private)
    private Produto produto;
    private int quantidade;
    private double precoUnitario;

    // Métodos
    
    // Construtor
    public ItemVenda(Produto produto, int quantidade, double precoUnitario) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Getters 
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    public double getPrecoUnitario() {
        return precoUnitario;
    }

    // getSubtotal() 
    public double getSubtotal() {
        return quantidade * precoUnitario;
    }
    
    // toString()
    @Override
    public String toString() {
        return quantidade + "x " + produto + " - R$ " + precoUnitario
                + " = R$ " + getSubtotal();
    }
}