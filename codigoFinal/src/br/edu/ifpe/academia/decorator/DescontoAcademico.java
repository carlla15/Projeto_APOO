package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Mensalidade;

public class DescontoAcademico extends AlunoDecorator {

    public DescontoAcademico(Mensalidade mensalidadeDecorada) {
        super(mensalidadeDecorada);
    }

    @Override
    public double getValor() {
        return super.getValor() * 0.9; // Aplica 10% de desconto
    }
}
