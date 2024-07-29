package codigoFinal;

public class DescontoFamiliar extends AlunoDecorator {
    private double desconto;

    public DescontoFamiliar(Aluno aluno, double desconto) {
        super(aluno);
        this.desconto = desconto;
    }

    @Override
    public double getMensalidade() {
        return super.getMensalidade() * (1 - desconto);
    }
}
