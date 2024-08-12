package br.edu.ifpe.academia.apresentacao;

import br.edu.ifpe.academia.model.Aluno;
import br.edu.ifpe.academia.service.AlunoService;
import br.edu.ifpe.academia.util.Registrador;

import java.util.List;
import java.util.Scanner;

public class Apresentacao {
    private AlunoService alunoService = new AlunoService();
    private Registrador registrador = Registrador.getInstancia();
    private Scanner scanner = new Scanner(System.in);

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

        Aluno aluno = new Aluno.Builder()
                .cpf(cpf)
                .nome(nome)
                .endereco(endereco)
                .idade(idade)
                .build();

        try {
            alunoService.adicionarAluno(aluno);
            registrador.log("Aluno adicionado: " + nome);
            System.out.println("Aluno adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar aluno: " + e.getMessage());
        }
    }

    private void buscarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        try {
            Aluno aluno = alunoService.buscarAluno(cpf);
            if (aluno != null) {
                System.out.println("Aluno encontrado:");
                System.out.println("Nome: " + aluno.getNome());
                System.out.println("Endereço: " + aluno.getEndereco());
                System.out.println("Idade: " + aluno.getIdade());
                registrador.log("Aluno buscado: " + aluno.getNome());
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
    }

    private void atualizarAluno() {
        System.out.print("CPF do aluno a ser atualizado: ");
        String cpf = scanner.nextLine();
        try {
            Aluno alunoExistente = alunoService.buscarAluno(cpf);
            if (alunoExistente != null) {
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo Endereço: ");
                String endereco = scanner.nextLine();
                System.out.print("Nova Idade: ");
                int idade = obterNumero();

                Aluno aluno = new Aluno.Builder()
                        .cpf(cpf)
                        .nome(nome)
                        .endereco(endereco)
                        .idade(idade)
                        .build();

                alunoService.atualizarAluno(aluno);
                registrador.log("Aluno atualizado: " + nome);
                System.out.println("Aluno atualizado com sucesso.");
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    private void removerAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        try {
            alunoService.removerAluno(cpf);
            registrador.log("Aluno removido: " + cpf);
            System.out.println("Aluno removido com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }

    private void listarAlunos() {
        try {
            List<Aluno> alunos = alunoService.listarAlunos();
            if (alunos.isEmpty()) {
                System.out.println("Nenhum aluno cadastrado.");
            } else {
                System.out.println("Lista de Alunos:");
                System.out.println();
                for (Aluno aluno : alunos) {
                    System.out.println("CPF: " + aluno.getCpf());
                    System.out.println("Nome: " + aluno.getNome());
                    System.out.println("Endereço: " + aluno.getEndereco());
                    System.out.println("Idade: " + aluno.getIdade());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
    }

    private int obterNumero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Idade inválida. Digite um número.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
}
