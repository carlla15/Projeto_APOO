package codigoFinal;

public class DescontoAcademico extends AlunoDecorator {
    private double desconto;

    public DescontoAcademico(Aluno aluno, double desconto) {
        super(aluno);
        this.desconto = desconto;
    }

    @Override
    public double getMensalidade() {
        return super.getMensalidade() * (1 - desconto);
    }
}
