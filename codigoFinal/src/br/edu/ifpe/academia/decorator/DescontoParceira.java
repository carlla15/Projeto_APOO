package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Mensalidade;

public class DescontoParceira extends AlunoDecorator {
    public DescontoParceira(Mensalidade mensalidade) {
        super(mensalidade);
    }

    @Override
    public double getValor() {
        return mensalidade.getValor() * 0.8;  
    }
}