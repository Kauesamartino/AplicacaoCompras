import models.CartaoDeCredito;
import models.Compra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1 ;
        while (sair != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = scanner.next();

            System.out.println("Digite o valor da compra: ");
            double valor = scanner.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = scanner.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                sair = 0;
            }
        }
        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        for (Compra c : cartao.getCompras()){
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " + cartao.getSaldo());
    }
}