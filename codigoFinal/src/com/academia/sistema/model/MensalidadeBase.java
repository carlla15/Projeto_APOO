package com.academia.sistema.model;


public class MensalidadeBase implements Mensalidade {
    private double valor;

    public MensalidadeBase(double valor) {
        this.valor = valor;
    }

    @Override
    public double getValor() {
        return valor;
    }
}
