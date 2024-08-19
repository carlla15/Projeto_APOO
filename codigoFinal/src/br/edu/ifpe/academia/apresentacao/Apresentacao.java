package br.edu.ifpe.academia.presentation;

import br.edu.ifpe.academia.facade.AcademiaFachada;
import br.edu.ifpe.academia.model.Aluno;

import java.util.List;
import java.util.Scanner;

public class Apresentacao {
    private AcademiaFachada fachada;
    private Scanner scanner;

    public Apresentacao() {
        this.fachada = new AcademiaFachada();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.executar();
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = obterOpcao();
            processarOpcao(opcao);
        } while (opcao != 6);
    }

    private void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Adicionar Aluno");
        System.out.println("2. Buscar Aluno");
        System.out.println("3. Atualizar Aluno");
        System.out.println("4. Remover Aluno");
        System.out.println("5. Listar Alunos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int obterOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida. Digite um número.");
            scanner.next();
            exibirMenu();
        }
        return scanner.nextInt();
    }

    private void processarOpcao(int opcao) {
        scanner.nextLine(); 
        switch (opcao) {
            case 1:
                adicionarAluno();
                break;
            case 2:
                buscarAluno();
                break;
            case 3:
                atualizarAluno();
                break;
            case 4:
                removerAluno();
                break;
            case 5:
                listarAlunos();
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = obterNumero();

        fachada.adicionarAluno(cpf, nome, endereco, idade);

        System.out.print("O aluno tem desconto? (academico/familiar/parceria/nenhum): ");
        String tipoDesconto = scanner.nextLine();

        double mensalidadeFinal = 150; 

        if (!tipoDesconto.equals("nenhum")) {
            mensalidadeFinal = fachada.calcularMensalidadeComDesconto(cpf, tipoDesconto);
        }

        Aluno aluno = fachada.buscarAluno(cpf);
        if (aluno != null) {
            System.out.println("Informações do aluno:");
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("Idade: " + aluno.getIdade());
            System.out.println("Mensalidade final: R$ " + mensalidadeFinal);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void buscarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Aluno aluno = fachada.buscarAluno(cpf);
        if (aluno != null) {
            System.out.println("Aluno encontrado:");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("Idade: " + aluno.getIdade());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void atualizarAluno() {
        System.out.print("CPF do aluno a ser atualizado: ");
        String cpf = scanner.nextLine();
        Aluno alunoExistente = fachada.buscarAluno(cpf);
        if (alunoExistente != null) {
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Nova Idade: ");
            int idade = obterNumero();

            fachada.atualizarAluno(cpf, nome, endereco, idade);
            System.out.println("Aluno atualizado com sucesso.");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void removerAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        fachada.removerAluno(cpf);
        System.out.println("Aluno removido com sucesso.");
    }

    private void listarAlunos() {
        List<Aluno> alunos = fachada.listarAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : alunos) {
                System.out.println("CPF: " + aluno.getCpf());
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Endereço: " + aluno.getEndereco());
                System.out.println("Idade: " + aluno.getIdade());
                System.out.println();
            }
        }
    }

    private int obterNumero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Número inválido. Digite um número.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
