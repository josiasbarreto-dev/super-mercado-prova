package com.github.josiasbarreto_dev.super_mercado_prova.Item;

import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

public class Item {
    private Produto produto;
    private int quantidade;
    private double valorDoItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorDoItem() {
        return valorDoItem;
    }

    public void setValorDoItem(double valorDoItem) {
        this.valorDoItem = valorDoItem;
    }

    public double defineValorTotal() {
        double valorTotal = produto.getPreco() * quantidade;
        setValorDoItem(valorTotal);
        return valorTotal;
    }
}
