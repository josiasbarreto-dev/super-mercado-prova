
# 🛒 SuperMercadoProva

Este projeto simula um sistema simples de gerenciamento de vendas de um supermercado, com foco em controle de estoque, criação de pedidos, cálculo de valores e troco, conforme descrito no diagrama de classes fornecido na prova.

## 📚 Objetivo

A aplicação foi desenvolvida com o objetivo de praticar os conceitos de orientação a objetos em Java, como composição, agregação, encapsulamento e reutilização de código, além de lógica de programação aplicada a problemas do mundo real.

## 🧩 Estrutura de Classes

O projeto é composto pelas seguintes classes:

- `Produto`: representa um item vendável no supermercado.
- `Item`: representa um produto com quantidade associado a um pedido.
- `Pedido`: gerencia uma lista de itens, calcula valor total e interage com o estoque.
- `Estoque`: armazena a lista de produtos disponíveis e permite movimentação (entrada/baixa).
- `Menu`: oferece a interface para o usuário interagir com o sistema.
- `Main`: classe de entrada da aplicação, inicializa o menu.

### 📊 Diagrama de Classes

O projeto foi implementado conforme o diagrama de classes UML fornecido na prova (ver imagem da atividade).

## ✅ Funcionalidades

### 🛠️ Tarefa A - Correção de Bug

[//]: # (- Corrigido o bug relacionado ao uso incorreto do tipo `Object` no cálculo do valor total dos pedidos.)

[//]: # (- Substituídos métodos `get&#40;&#41;` e `set&#40;&#41;` genéricos por métodos específicos como `getPreco&#40;&#41;`, `getQuantidade&#40;&#41;` etc.)

### 💰 Tarefa B - Cálculo do Troco

- Implementado método `calcularTroco(double valorPago)` na classe `Pedido` ou `Menu`.
- O método retorna a diferença entre valor pago e valor total da compra.

### 🧮 Tarefa C - Menor Quantidade de Notas

- Implementado método `calcularNotasTroco(double troco)` que converte o valor do troco em reais (inteiros - notas) e determina a menor combinação de cédulas.

## 🚀 Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/josiasbarreto-dev/super-mercado-prova.git
   ```
2. Compile o projeto:
   ```bash
   javac com/github/josiasbarreto_dev/super_mercado_prova/*.java
   ```
3. Execute a aplicação:
   ```bash
   java com.github.josiasbarreto_dev.super_mercado_prova.Main
   ```

## 📁 Estrutura de Diretórios

```
supermercado-prova/
├── com/
│   └── github/
│       └── josiasbarreto_dev/
│           └── super_mercado_prova/
│               ├── Produto.java
│               ├── Item.java
│               ├── Pedido.java
│               ├── Estoque.java
│               ├── Menu.java
│               └── Main.java
└── README.md
```

## 🧪 Exemplos de Uso

- Adicionar produtos ao estoque
- Criar pedidos e adicionar itens
- Calcular o valor total da compra
- Informar valor pago e exibir troco
- Exibir a quantidade mínima de notas para o troco.

## 👨‍💻 Autor

- Nome: **Josias Barreto**
- GitHub: [https://github.com/josiasbarreto-dev](https://github.com/josiasbarreto-dev)

## 📄 Licença

Este projeto é de uso educacional e está sob a licença MIT.
