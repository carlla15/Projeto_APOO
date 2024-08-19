package br.edu.ifpe.academia.facade;

import br.edu.ifpe.academia.decorator.DescontoAcademico;
import br.edu.ifpe.academia.decorator.DescontoFamiliar;
import br.edu.ifpe.academia.decorator.DescontoParceira;
import br.edu.ifpe.academia.model.Aluno;
import br.edu.ifpe.academia.service.AlunoService;

import java.util.List;

public class AcademiaFachada {
    private AlunoService alunoService;

    public AcademiaFachada() {
        this.alunoService = new AlunoService();
    }

    public void adicionarAluno(String cpf, String nome, String endereco, int idade) {
        Aluno aluno = new Aluno.Builder()
                .cpf(cpf)
                .nome(nome)
                .endereco(endereco)
                .idade(idade)
                .build();
        alunoService.adicionarAluno(aluno);
    }

    public Aluno buscarAluno(String cpf) {
        return alunoService.buscarAluno(cpf);
    }

    public void atualizarAluno(String cpf, String nome, String endereco, int idade) {
        Aluno aluno = new Aluno.Builder()
                .cpf(cpf)
                .nome(nome)
                .endereco(endereco)
                .idade(idade)
                .build();
        alunoService.atualizarAluno(aluno);
    }

    public void removerAluno(String cpf) {
        alunoService.removerAluno(cpf);
    }

    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    public double calcularMensalidadeComDesconto(String cpf, String tipoDesconto) {
        Aluno aluno = alunoService.buscarAluno(cpf);
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não encontrado para o CPF: " + cpf);
        }

        Mensalidade mensalidade = new MensalidadeBase(150); // Valor base da mensalidade

        switch (tipoDesconto) {
            case "academico":
                mensalidade = new DescontoAcademico(mensalidade);
                break;
            case "familiar":
                mensalidade = new DescontoFamiliar(mensalidade);
                break;
            case "parceria":
                mensalidade = new DescontoParceira(mensalidade);
                break;
            default:
                throw new IllegalArgumentException("Tipo de desconto inválido.");
        }

        return mensalidade.getValor();
    }
}