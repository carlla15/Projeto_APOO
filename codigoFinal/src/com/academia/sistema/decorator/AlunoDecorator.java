
package com.academia.sistema.decorator;

import com.academia.sistema.model.Aluno;

public abstract class AlunoDecorator extends Aluno {
    protected Aluno alunoDecorado;

    public AlunoDecorator(Aluno alunoDecorado) {
        super(new Aluno.Builder()
                .cpf(alunoDecorado.getCpf())
                .nome(alunoDecorado.getNome())
                .endereco(alunoDecorado.getEndereco())
                .idade(alunoDecorado.getIdade())
                .build());

        this.alunoDecorado = alunoDecorado;
    }

    @Override
    public double getValor() {
        return alunoDecorado.getValor();
    }
}
