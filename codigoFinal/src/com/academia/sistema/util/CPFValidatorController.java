package com.academia.sistema.util;

public class CPFValidatorController {

    private static CPFValidatorController instancia;

    private CPFValidatorController() {}

    public static synchronized CPFValidatorController getInstancia() {
        if (instancia == null) {
            instancia = new CPFValidatorController();
        }
        return instancia;
    }
    public boolean validarCPF(String cpf) {
        return CPFValidatorUtil.validarCPF(cpf);
    }

}
