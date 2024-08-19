package br.edu.ifpe.academia.model;


public class MensalidadeBase implements Mensalidade {
    private double valor =150.00;

    public MensalidadeBase() {
    }

    @Override
    public double getValor() {
        return valor;
    }
}
