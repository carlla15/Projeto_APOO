package br.edu.ifpe.academia.apresentacao;

import br.edu.ifpe.academia.model.Aluno;
import br.edu.ifpe.academia.service.AlunoService;
import br.edu.ifpe.academia.util.Registrador;

public class Apresentacao {
    private AlunoService alunoService = new AlunoService();
    private Registrador registrador = Registrador.getInstancia();

    public void adicionarAluno(String cpf, String nome, String endereco, int idade) {
        Aluno aluno = new Aluno.Builder()
                .cpf(cpf)
                .nome(nome)
                .endereco(endereco)
                .idade(idade)
                .build();
        alunoService.adicionarAluno(aluno);
        registrador.log("Aluno adicionado: " + nome);
    }

    public Aluno buscarAluno(String cpf) {
        Aluno aluno = alunoService.buscarAluno(cpf);
        if (aluno != null) {
            registrador.log("Aluno buscado: " + aluno.getNome());
        }
        return aluno;
    }

    public void atualizarAluno(String cpf, String nome, String endereco, int idade) {
        Aluno aluno = new Aluno.Builder()
                .cpf(cpf)
                .nome(nome)
                .endereco(endereco)
                .idade(idade)
                .build();
        alunoService.atualizarAluno(aluno);
        registrador.log("Aluno atualizado: " + nome);
    }

    public void removerAluno(String cpf) {
        alunoService.removerAluno(cpf);
        registrador.log("Aluno removido: " + cpf);
    }

    public void listarAlunos() {
        alunoService.listarAlunos().forEach(aluno -> 
            System.out.println("Nome: " + aluno.getNome() + ", CPF: " + aluno.getCpf())
        );
    }
}
