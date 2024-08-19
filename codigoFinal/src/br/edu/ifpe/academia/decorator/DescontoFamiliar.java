package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Mensalidade;

public class DescontoFamiliar implements Mensalidade {
    private Mensalidade base;

    public DescontoFamiliar(Mensalidade base) {
        this.base = base;
    }

    @Override
    public double getValor() {
        return base.getValor() * 0.85;
    }
}
