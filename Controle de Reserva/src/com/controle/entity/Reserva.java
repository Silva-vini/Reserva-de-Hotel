package com.controle.entity;

public class Reserva {
    private String nome;
    private String cpf;
    private String tipoDeQuarto;
    private int numeroDeDias;
    private double valorDiaria;
    public static final double MINIMO_STANDARD = 210.99;
    public static final double MINIMO_LUXO = 549.99;
    public static final double MINIMO_PRESIDENCIAL = 1000.99;



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTipoDeQuarto() {
        return tipoDeQuarto;
    }
    public void setTipoDeQuarto(String tipoDeQuarto) {
        this.tipoDeQuarto = tipoDeQuarto;
    }
    public int getNumeroDeDias() {
        return numeroDeDias;
    }
    public void setNumeroDeDias(int numeroDeDias) {
        this.numeroDeDias = numeroDeDias;
    }
    public double getValorDiaria() {
        return valorDiaria;
    }
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double calcularValorTotal (){
        double valorTotal = valorDiaria * numeroDeDias;
        return valorTotal;
    }


    @Override
    public String toString() {
        return "Hóspede: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                "Quarto: " + tipoDeQuarto + "\n" +
                "Valor da Diária: R$" + valorDiaria + "\n" +
                "Quantidade de Dias: " + numeroDeDias + "\n" +
                "Valor Total: R$" + calcularValorTotal();
    }
}
