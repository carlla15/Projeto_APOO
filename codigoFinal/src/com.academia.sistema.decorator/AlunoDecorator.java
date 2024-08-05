package com.academia.sistema.decorator;

import com.academia.Aluno;

public abstract class AlunoDecorator extends Aluno {
    protected Aluno aluno;

    public AlunoDecorator(Aluno aluno) {
        //super(aluno);
        this.aluno = aluno;
    }

    @Override
    public double getValor() {
        return aluno.getValor();
    }
}
