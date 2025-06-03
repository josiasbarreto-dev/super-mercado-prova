package com.github.josiasbarreto_dev.super_mercado_prova.Pedido;

import com.github.josiasbarreto_dev.super_mercado_prova.Item.Item;
import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
    private ArrayList<Item> listaItens = new ArrayList<>();
    private double valorTotalDoPedido = 0.0;

    Scanner scanner = new Scanner(System.in);

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    public void calcularValorTotal() {
        valorTotalDoPedido = 0.0;
        for (Item item : listaItens) {
            valorTotalDoPedido += (double) item.defineValorTotal();
        }
    }

    public boolean adicionaItemNaLista(Produto produto, int quantidade) {
        if (produto.getQuantidadeEmEstoque() >= quantidade) {
            listaItens.add(new Item(produto, quantidade));
            calcularValorTotal();
            return true;
        }
        return false;
    }

    public void imprimePedido() {
        for (Item item : listaItens) {
            System.out.printf("Produto: %s | Quantidade: %d | Total: %.2f\n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.getProduto().getPreco());
        }
        imprimeValorTotal();
    }

    public void imprimeValorTotal() {
        System.out.printf("Valor Total do Pedido: %.2f\n", valorTotalDoPedido);
    }

    public void limparCarrinho() {
        listaItens.clear();
        valorTotalDoPedido = 0.0;
    }

    public String recebeNomeDoTeclado() {
        System.out.print("Nome do produto: ");
        return scanner.nextLine();
    }

    public int recebeQuantidadeDoTeclado() {
        System.out.print("Quantidade: ");
        return scanner.nextInt();
    }
}