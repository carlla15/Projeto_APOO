package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Mensalidade;

public class DescontoParceira implements Mensalidade {
    private Mensalidade base;

    public DescontoParceira(Mensalidade base) {
        this.base = base;
    }

    @Override
    public double getValor() {
        return base.getValor() * 0.8;
    }
}
