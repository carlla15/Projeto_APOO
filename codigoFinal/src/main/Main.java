package main;

import com.academia.sistema.model.*;
import com.academia.sistema.decorator.DescontoAcademico;

public class Main {

   public static void main(String[] args) {
    Aluno alunoTESTE = new Aluno.Builder()
    .cpf("13426749440")
    .nome("Carlla")
    .endereco("centro")
    .idade(19)
    .build();

    Mensalidade alunoBase = alunoTESTE;

    alunoBase = new DescontoAcademico(alunoBase);
    
    alunoBase = new DescontoAcademico(alunoBase);

   }
}
