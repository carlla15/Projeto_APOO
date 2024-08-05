package com.academia.sistema.decorator;

import com.academia.sistema.model.*;

public class DescontoFamiliar implements Mensalidade {
    private Mensalidade base;
 
    public DescontoFamiliar(Mensalidade base) {
        this.base = base;
    }
  public double getValor(){
    return base.getValor();
  }
}