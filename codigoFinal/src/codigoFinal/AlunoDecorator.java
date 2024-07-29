package codigoFinal;

public abstract class AlunoDecorator extends Aluno {
    protected Aluno aluno;

    public AlunoDecorator(Aluno aluno) {
        super(new Aluno.Builder().comCpf(aluno.getCpf()).comNome(aluno.getNome()).comEndereco(aluno.getEndereco()).comIdade(aluno.getIdade()).comMensalidade(aluno.mensalidade));
        this.aluno = aluno;
    }

    @Override
    public double getMensalidade() {
        return aluno.getMensalidade();
    }
}

