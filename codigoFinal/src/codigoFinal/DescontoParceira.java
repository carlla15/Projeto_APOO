package codigoFinal;

public class DescontoParceira extends AlunoDecorator {
    private double desconto;

    public DescontoParceira(Aluno aluno, double desconto) {
        super(aluno);
        this.desconto = desconto;
    }

    @Override
    public double getMensalidade() {
        return super.getMensalidade() * (1 - desconto);
    }
}
