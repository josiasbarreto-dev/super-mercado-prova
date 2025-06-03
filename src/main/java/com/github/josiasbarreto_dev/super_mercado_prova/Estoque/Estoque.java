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

    public void inicializarEstoque(){
        Produto produto1 = new Produto(1, "Caneta", 3.50, 10);
        Produto produto2 = new Produto(2, "Lápis", 1.50, 5);
        Produto produto3 = new Produto(3, "Borracha", 0.50, 100);
        Produto produto4 = new Produto(4, "Caderno", 20.99, 15);
        Produto produto5 = new Produto(5, "Apontador", 2.00, 30);
        Produto produto6 = new Produto(6, "Marca-texto", 4.25, 12);
        Produto produto7 = new Produto(7, "Régua 30cm", 3.80, 20);
        Produto produto8 = new Produto(8, "Cola branca", 5.00, 25);
        Produto produto9 = new Produto(9, "Tesoura escolar", 6.50, 18);

         cadastrarProduto(produto1);
         cadastrarProduto(produto2);
         cadastrarProduto(produto3);
         cadastrarProduto(produto4);
         cadastrarProduto(produto5);
         cadastrarProduto(produto6);
         cadastrarProduto(produto7);
         cadastrarProduto(produto8);
         cadastrarProduto(produto9);
    }

    public Produto encontrarProdutoPorNome(String nome){
       return getListaDeProdutos().stream()
               .filter(p -> p.getNome().equalsIgnoreCase(nome))
               .findFirst().orElse(null);
    }

    public Produto encontrarProdutoPorID(int id){
        return getListaDeProdutos().stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    public boolean cadastrarProduto(Produto produto){
        return getListaDeProdutos().add(produto);
    }

    public void imprimirCatalogoDoEstoque(){
        for(Produto p : listaDeProdutos){
            System.out.printf("ID: %d | Nome: %s | Preço: %.2f | Quantidade: %d\n",
                    p.getId(), p.getNome(), p.getPreco(), p.getQuantidadeEmEstoque());
        }
    }

    public boolean darBaixaEmEstoque(String nome, int quantidadeParaDarBaixa){
        Produto produto = encontrarProdutoPorNome(nome);
        if(produto != null && temEstoque(produto, id)){
            int total = produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa;
            produto.setQuantidadeEmEstoque(total);
            return true;
        }
        return false;
    }

    public boolean darBaixaEmEstoque(int id, int quantidadeParaDarBaixa){
       Produto produto = encontrarProdutoPorID(id);
       if (produto != null && temEstoque(produto, id)){
           int total = produto.getQuantidadeEmEstoque() - quantidadeParaDarBaixa;
           produto.setQuantidadeEmEstoque(total);
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

    public boolean temEstoque (Produto produto, int quantidadeParaDarBaixa){
       return  getQuantidadeAtualEmEstoque(produto) >= quantidadeParaDarBaixa;
    }
}
