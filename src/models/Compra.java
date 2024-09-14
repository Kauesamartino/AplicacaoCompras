package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra implements Comparable<Compra>{
    private String descricao;
    private double valor;
    private Date data;
    private String categoria;

    // Construtor
    public Compra(String descricao, double valor, Date data, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return "Descrição: " + descricao + ", Valor: R$" + valor + ", Data: " + formatador.format(data) + ", Categoria: " + categoria;
    }

    @Override
    public int compareTo(Compra o) {
        return this.getCategoria().compareTo(o.getCategoria());
    }
}

