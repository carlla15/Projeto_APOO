package codigoFinal;

public class DescontoFamiliar implements Mensalidade {
    private Mensalidade base;
 
    public DescontoFamiliar(Mensalidade base) {
        this.base = base;
    }
  public double getValor(){
    return base.getValor();
  }
}
