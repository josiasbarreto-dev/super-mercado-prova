package com.github.josiasbarreto_dev.super_mercado_prova.Estoque;

import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

import java.util.ArrayList;

public class Estoque {
    private int id = 1;
    private ArrayList<Produto> listaDeProdutos = new ArrayList<>();

    public Estoque() {
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
        Produto produto1 = new Produto(1, "Caneta", 3.50, 10);
        Produto produto2 = new Produto(2, "Lápis", 1.50, 5);
        Produto produto3 = new Produto(3, "Borracha", 0.50, 100);
        Produto produto4 = new Produto(4, "Caderno", 20.99, 15);
        Produto produto5 = new Produto(5, "Apontador", 2.00, 30);
        Produto produto6 = new Produto(6, "Marca-texto", 4.25, 12);
        Produto produto7 = new Produto(7, "Régua 30cm", 3.80, 20);
        Produto produto8 = new Produto(8, "Cola branca", 5.00, 25);
        Produto produto9 = new Produto(9, "Tesoura escolar", 6.50, 18);

         cadastraProduto(produto1);
         cadastraProduto(produto2);
         cadastraProduto(produto3);
         cadastraProduto(produto4);
         cadastraProduto(produto5);
         cadastraProduto(produto6);
         cadastraProduto(produto7);
         cadastraProduto(produto8);
         cadastraProduto(produto9);
    }

    public Produto encontraProduto(String nome){
       return getListaDeProdutos().stream()
               .filter(p -> p.getNome().equalsIgnoreCase(nome))
               .findFirst().orElse(null);
    }

    public Produto encontraProduto(int id){
        return getListaDeProdutos().stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    public boolean cadastraProduto(Produto produto){
        return getListaDeProdutos().add(produto);
    }

    public void imprimeCatalogoDoEstoque(){
        for(Produto p : listaDeProdutos){
            System.out.printf("ID: %d | Nome: %s | Preço: %.2f | Quantidade: %d\n",
                    p.getId(), p.getNome(), p.getPreco(), p.getQuantidadeEmEstoque());
        }
    }

    public boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa){
        Produto p = encontraProduto(nome);
        if(p != null && p.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa){
            int total = p.getQuantidadeEmEstoque() - quantidadeParaDarBaixa;
            p.setQuantidadeEmEstoque(total);
            return true;
        }
        return false;
    }

    public boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa){
       Produto p = encontraProduto(id);
       if (p != null && p.getQuantidadeEmEstoque() >= quantidadeParaDarBaixa){
           int total = p.getQuantidadeEmEstoque() - quantidadeParaDarBaixa;
           p.setQuantidadeEmEstoque(total);
           return true;
       }
        return false;
    }

    public int getQuantidadeAtualEmEstoque(Produto produto){
        return produto.getQuantidadeEmEstoque();
    }

    public int getPosicaoDoProdutoNaLista(Produto produto){
        return listaDeProdutos.indexOf(produto) + 1;
    }

    public boolean temEstoqueOuNao(Produto produto, int quantidadeParaDarBaixa){
       return  getQuantidadeAtualEmEstoque(produto) >= quantidadeParaDarBaixa;
    }
}
