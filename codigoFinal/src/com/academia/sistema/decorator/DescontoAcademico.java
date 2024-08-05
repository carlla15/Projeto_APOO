package com.academia.sistema.decorator;

import com.academia.sistema.model.*;

public class DescontoAcademico implements Mensalidade {

    private Mensalidade base;
    public DescontoAcademico(Mensalidade base) {
        this.base=base;

    }
    @Override
    public double getValor() {
        return base.getValor();
    }
}
