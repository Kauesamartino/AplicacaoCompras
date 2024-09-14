import models.CartaoDeCredito;
import models.Compra;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int opcao;
        do {
            System.out.println("\n**********************");
            System.out.println("\nMenu:");
            System.out.println("1. Realizar compra");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Listar compras realizadas");
            System.out.println("4. Aumentar limite do cartão");
            System.out.println("5. Sair");
            System.out.println("\n**********************\n");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    realizarCompra(cartao, scanner);
                    break;
                case 2:
                    consultarSaldo(cartao);
                    break;
                case 3:
                    listarCompras(cartao);
                    break;
                case 4:
                    aumentarLimite(cartao, scanner);
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 5);
    }

    private static void realizarCompra(CartaoDeCredito cartao, Scanner scanner) {
        scanner.nextLine();
        System.out.print("Digite a descrição da compra: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o valor da compra: ");
        double valor = scanner.nextDouble();

        scanner.nextLine();
        System.out.print("Digite a categoria da compra: ");
        String categoria = scanner.nextLine();

        Date data = new Date();

        Compra compra = new Compra(descricao, valor, data, categoria);
        boolean compraRealizada = cartao.realizaCompra(compra);

        if (compraRealizada) {
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar esta compra.");
        }
    }

    private static void consultarSaldo(CartaoDeCredito cartao) {
        System.out.println("\nSaldo atual do cartão: R$" + cartao.getSaldo());
    }

    private static void listarCompras(CartaoDeCredito cartao) {
        cartao.listarCompras();
    }

    private static void aumentarLimite(CartaoDeCredito cartao, Scanner scanner) {
        System.out.print("Digite o valor para aumentar o limite: ");
        double valor = scanner.nextDouble();
        cartao.aumentarLimite(valor);
        System.out.println("Limite aumentado com sucesso!");
    }
}
