package codigoFinal;

public abstract class AlunoDecorator extends Aluno {
    protected Aluno aluno;

    public AlunoDecorator(Aluno aluno) {
        super(new Aluno.Builder()
            .cpf(aluno.getCpf())
            .nome(aluno.getNome())
            .endereco(aluno.getEndereco())
            .idade(aluno.getIdade())
            .mensalidade(aluno.getMensalidade()));
        this.aluno = aluno;
    }

    @Override
    public double getMensalidade() {
        return aluno.getMensalidade();
    }
}
