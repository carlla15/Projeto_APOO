package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.Mensalidade;

public abstract class AlunoDecorator implements Mensalidade {
    protected Mensalidade mensalidadeDecorada;

    public AlunoDecorator(Mensalidade mensalidadeDecorada) {
        this.mensalidadeDecorada = mensalidadeDecorada;
    }

    @Override
    public double getValor() {
        return mensalidadeDecorada.getValor();
    }
}

