package com.github.josiasbarreto_dev.super_mercado_prova.Estoque;

import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

import java.util.ArrayList;

public class Estoque {
    private int id = 1;
    private ArrayList<Produto> listaDeProdutos;

    public Estoque(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public void inicializaEstoque(){
     // Todo: Necessário implementar!
    }

    public Produto encontraProduto(String nome){
        // Todo: Necessário implementar!
        return new Produto(1, "Biscoito", 3.50, 10);
    }

    public Produto encontraProduto(int id){
        // Todo: Necessário implementar!
        return new Produto(1, "Biscoito", 3.50, 10);
    }

    public boolean cadastraProduto(Produto produto){
        // Todo: Necessário implementar!
        return true;
    }

    public void imprimeCatalogoDoEstoque(){
        System.out.println(" ");
    }

    public boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa){
        return true;
    }

    public boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa){
        return true;
    }

    public int getQuantidadeAtualEmEstoque(Produto produto){
        return 1;
    }

    public int getPosicaoDoProdutoNaLista(Produto produto){
        return 1;
    }

    public boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa){
        return true;
    }
}
