
package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Aluno;

public abstract class AlunoDecorator extends Aluno {
    protected Aluno alunoDecorado;

    public AlunoDecorator(Aluno alunoDecorado) {
        super(alunoDecorado);
        this.alunoDecorado = alunoDecorado;
    }

    @Override
    public double getValor() {
        return alunoDecorado.getValor();
    }
}
