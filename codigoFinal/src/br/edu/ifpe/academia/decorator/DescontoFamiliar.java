package br.edu.ifpe.academia.decorator;

import br.edu.ifpe.academia.model.*;

public class DescontoFamiliar implements Mensalidade {
    private Mensalidade base;
 
    public DescontoFamiliar(Mensalidade base) {
        this.base = base;
    }
  public double getValor(){
    return base.getValor()* 0.85;
  }
}