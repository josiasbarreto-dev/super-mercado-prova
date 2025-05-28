package com.github.josiasbarreto_dev.super_mercado_prova.Pedido;

import com.github.josiasbarreto_dev.super_mercado_prova.Item.Item;
import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

import java.util.ArrayList;

public class Pedido {
    private ArrayList<Item> listaDeItens;
    private double valorTotalDoPedido = 0;

    public Pedido(ArrayList<Item> listaDeItens, double valorTotalDoPedido) {
        this.listaDeItens = listaDeItens;
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    public ArrayList<Item> getListaDeItens() {
        return listaDeItens;
    }


    public void setListaDeItens(ArrayList<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public double getValorTotalDoPedido() {
        return valorTotalDoPedido;
    }

    public void setValorTotalDoPedido(double valorTotalDoPedido) {
        this.valorTotalDoPedido = valorTotalDoPedido;
    }

    public void calculaValorTotal(){
        //todo
    }

    public boolean adicionaItemNaLista(Produto produto, int quantidade){
        //todo
        return true;
    }

    public void imprimePedido(){
        System.out.println("Lista de Itens: " + getListaDeItens() + "Total: R$ " + valorTotalDoPedido);
    }

    
}
