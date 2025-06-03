package com.github.josiasbarreto_dev.super_mercado_prova.Menu;

import com.github.josiasbarreto_dev.super_mercado_prova.Estoque.Estoque;
import com.github.josiasbarreto_dev.super_mercado_prova.Pedido.Pedido;
import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

import java.util.Scanner;

public class Menu {
    private Estoque estoque = new Estoque();
    private Pedido pedido = new Pedido();
    private Scanner scanner = new Scanner(System.in);

    public void controlaMenu() {
        estoque.inicializarEstoque();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n1 - Ver Estoque" +
                    "\n2 - Fazer Pedido" +
                    "\n3 - Imprime Pedido" +
                    "\n4 - Finalizar" +
                    "\n5 - Pagar" +
                    "\n6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    mostraEstoque();
                    break;
                case 2:
                    System.out.println("Informe o nome do produto:");
                    String nome = pedido.receberNomeDoTeclado();

                    System.out.println("Informe a quantidade:");
                    int quantidade = pedido.receberQuantidadeDoTeclado();

                    Produto produto = estoque.encontrarProdutoPorNome(nome);
                    if (produto != null && estoque.temEstoque(produto, quantidade)) {
                        pedido.adicionarItemNaLista(produto, quantidade);
                        estoque.darBaixaEmEstoque(produto.getId(), quantidade);
                    } else {
                        System.out.println("Produto não encontrado ou estoque insuficiente.");
                    }
                    break;
                case 3:
                    pedido.imprimirPedido();
                    break;
                case 4:
                    pedido.imprimirPedido();
                    pedido.limparCarrinho();
                    break;
                case 5:
                    System.out.println("Informe o valor pago:");
                    double valorPago = scanner.nextDouble();
                    scanner.nextLine();

                    if (valorPago >= pedido.getValorTotalDoPedido()) {
                        System.out.println("Pagamento realizado com sucesso!");
                        double troco = defineTrocoAReceber(valorPago);
                        System.out.printf("Troco a receber: %.2f\n", troco);
                        System.out.println("Menor quantidade de notas para o troco: " + calculaQuantidadeDeNotas(troco));
                        pedido.limparCarrinho();
                    } else {
                        System.out.println("Valor pago é insuficiente.");
                    }
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        // scanner.close(); // Descomente se não for usá-lo em outro lugar
    }

    public void mostraEstoque() {
        estoque.imprimirCatalogoDoEstoque();
    }

    public double defineTrocoAReceber(double valorPago) {
        return valorPago - pedido.getValorTotalDoPedido();
    }

    //todo: Desenvolver um método onde recebe o valor do troco e calcule a menor quantidade de notas. (difícil)
    public int calculaQuantidadeDeNotas(double valorTroco) {
        int[] notas = {100, 50, 20, 10, 5, 2};
        int quantidadeNotas = 0;
        int trocoInteiro = (int) valorTroco; // Considera só a parte inteira

        for (int nota : notas) {
            int qtd = trocoInteiro / nota; // calcula quantas notas dessa são necessárias
            quantidadeNotas += qtd;
            trocoInteiro %= nota; // reduz o troco
        }

        return quantidadeNotas;
    }

}
