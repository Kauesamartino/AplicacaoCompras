package models;

import java.util.*;

public class CartaoDeCredito {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    // Constructor
    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    // Métodos

    // Método para realizar compra
    public void realizaCompra(CartaoDeCredito cartao){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a descrição da compra: ");
        String descricao = scanner.nextLine();
        System.out.println("Informe o valor da compra: ");
        double valor = scanner.nextDouble();
        Date data = new Date();
        scanner.nextLine();
        System.out.println("Informe a categoria da compra: ");
        String categoria = scanner.nextLine();

        Compra compra = new Compra(descricao, valor, data, categoria);

        if (this.saldo >= valor){
            boolean compraRealizada = true;
            this.saldo -= valor;
            this.compras.add(compra);
            System.out.println("Compra realizada com sucesso!");
        } else {
            boolean compraRealizada = false;
            System.out.println("Saldo insuficiente para realizar essa compra");
        }
    }


    // Método para visualizar o saldo
    public void consultaSaldo(CartaoDeCredito cartao){
        System.out.printf("O seu saldo é de R$%.2f%n", this.saldo);
    }

    // Método para listar compras
    public void listarCompras(CartaoDeCredito cartao){
        System.out.println("\nCOMPRAS REALIZADAS:\n");
        Collections.sort(compras);
        for (Compra compra : compras){
            System.out.println(compra.toString());
        }
    }

    // Método para aumentar limite
    public void aumentarLimite(CartaoDeCredito cartao){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor que deseja aumentar o limite: ");
        double valor = scanner.nextDouble();

        this.limite += valor;
        this.saldo += valor;
    }

    // Método para chamar menu
    public void menu(CartaoDeCredito cartao){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n**********************" +
                    "\nMENU DE COMPRAS" +
                    "\n1 - Realizar compras" +
                    "\n2 - Consultar saldo" +
                    "\n3 - Listar compras realizadas" +
                    "\n4 - Aumentar limite do cartão" +
                    "\n5 - Sair" +
                    "\n**********************");

            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cartao.realizaCompra(cartao);
                    break;
                case 2:
                    cartao.consultaSaldo(cartao);
                    break;
                case 3:
                    cartao.listarCompras(cartao);
                    break;
                case 4:
                    cartao.aumentarLimite(cartao);
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, e");
            }
        } while (opcao != 5);
    }
}

