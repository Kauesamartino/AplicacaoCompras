package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    // Método para lançar uma compra
    public boolean realizaCompra(Compra compra){
        if (this.saldo >= compra.getValor()){
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        }
        return false;
    }

    // Método para consultar o saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para listar compras realizadas
    public void listarCompras() {
        System.out.println("\nCOMPRAS REALIZADAS:\n");
        Collections.sort(compras);
        for (Compra c : compras){
            System.out.println(c.toString());
        }
    }

    // Método para aumentar o limite do cartão
    public void aumentarLimite(double valor) {
        this.limite += valor;
        this.saldo += valor;
    }
}

