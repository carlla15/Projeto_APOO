package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Mensalidade;

public class DescontoAcademico extends AlunoDecorator {
    public DescontoAcademico(Mensalidade mensalidade) {
        super(mensalidade);
    }

    @Override
    public double getValor() {
        return mensalidade.getValor() * 0.9;  
    }
}
