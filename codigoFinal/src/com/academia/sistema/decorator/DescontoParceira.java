package com.academia.sistema.decorator;

import com.academia.sistema.model.*;

public class DescontoParceira implements Mensalidade {
	   private Mensalidade base;

	   public DescontoParceira(Mensalidade base){
	    this.base= base;
	   }
	   @Override
	   public double getValor() {
	       return base.getValor();
	   }
	}
