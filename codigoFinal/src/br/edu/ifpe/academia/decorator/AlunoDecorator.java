package br.edu.ifpe.academia.decorator;
//
import br.edu.ifpe.academia.model.Aluno;
import br.edu.ifpe.academia.model.*;

public abstract class AlunoDecorator implements Mensalidade {
    protected Mensalidade mensalidade;

    public AlunoDecorator(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

    @Override
    public double getValor() {
        return mensalidade.getValor();
    }
}