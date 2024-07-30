package codigoFinal;

public class Main {

    Aluno aluno = new Aluno.Builder()
    .cpf("13426749440")
    .nome("Carlla")
    .endereco("centro")
    .idade(19)
    .mensalidade(new MensalidadeBase(100.00)) 
    .build();

Aluno descontoAcademico = new DescontoAcademico(aluno, 0.10); 

  
}
