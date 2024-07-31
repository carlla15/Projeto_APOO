package codigoFinal;

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
