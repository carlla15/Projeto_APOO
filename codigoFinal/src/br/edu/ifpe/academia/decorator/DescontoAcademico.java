package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.*;

public class DescontoAcademico implements Mensalidade {

    private Mensalidade base;
    
    public DescontoAcademico(Mensalidade base) {
        this.base=base;

    }
    @Override
    public double getValor() {
        return base.getValor()*0.9;
    }
}
