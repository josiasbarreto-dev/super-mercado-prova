package com.github.josiasbarreto_dev.super_mercado_prova.Menu;

import com.github.josiasbarreto_dev.super_mercado_prova.Estoque.Estoque;
import com.github.josiasbarreto_dev.super_mercado_prova.Item.Item;
import com.github.josiasbarreto_dev.super_mercado_prova.Pedido.Pedido;
import com.github.josiasbarreto_dev.super_mercado_prova.Produto.Produto;

import java.util.Scanner;

public class Menu {
    private Estoque estoque = new Estoque();
    private Pedido pedido = new Pedido();
    private Scanner scanner = new Scanner(System.in);

    public void controlaMenu() {
        estoque.inicializaEstoque();
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
                    String nome = pedido.recebeNomeDoTeclado();

                    System.out.println("Informe a quantidade:");
                    int quantidade = pedido.recebeQuantidadeDoTeclado();

                    Produto produto = estoque.encontraProduto(nome);
                    if (produto != null && estoque.temEstoqueOuNao(produto, quantidade)) {
                        pedido.adicionaItemNaLista(produto, quantidade);
                        estoque.darBaixaEmEstoque(produto.getId(), quantidade);
                    } else {
                        System.out.println("Produto não encontrado ou estoque insuficiente.");
                    }
                    break;
                case 3:
                    pedido.imprimePedido();
                    break;
                case 4:
                    pedido.imprimePedido();
                    pedido.limparCarrinho();
                    break;
                case 5:
                    System.out.println("Informe o valor pago:");
                    double valorPago = scanner.nextDouble();
                    scanner.nextLine();

                    if (valorPago >= pedido.getValorTotalDoPedido()) {
                        System.out.println("Pagamento realizado com sucesso!");
                        defineTrocoAReceber(valorPago);
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
        estoque.imprimeCatalogoDoEstoque();
    }

    public void defineTrocoAReceber(double valorPago) {
        double troco = valorPago - pedido.getValorTotalDoPedido();
        System.out.printf("Troco a receber: %.2f\n", troco);
    }
}
