package main;


import com.academia.sistema.model.Aluno;
import com.academia.sistema.service.AlunoService;
import java.util.List;
import java.util.Scanner;

public class Apresentacao {
    private static AlunoService alunoService = new AlunoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            processarOpcao(opcao);
        } while (opcao != 6);
    }

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Adicionar Aluno");
        System.out.println("2. Buscar Aluno");
        System.out.println("3. Atualizar Aluno");
        System.out.println("4. Remover Aluno");
        System.out.println("5. Listar Alunos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
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

    private static void adicionarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); 

        Aluno aluno = new Aluno.Builder()
                .cpf(cpf)
                .nome(nome)
                .endereco(endereco)
                .idade(idade)
                .build();

        alunoService.adicionarAluno(aluno);
        System.out.println("ALUNO ADICIONADO.");
    }

    private static void buscarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Aluno aluno = alunoService.buscarAluno(cpf);

        if (aluno != null) {
            System.out.println("Aluno encontrado:");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("Idade: " + aluno.getIdade());
        } else {
            System.out.println("ALUNO NÂO ENCONTRADO.");
            
        }
    }

    private static void atualizarAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        Aluno aluno = alunoService.buscarAluno(cpf);

        if (aluno != null) {
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Nova Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); 

            aluno = new Aluno.Builder()
                    .cpf(cpf)
                    .nome(nome)
                    .endereco(endereco)
                    .idade(idade)
                    .build();

            alunoService.atualizarAluno(aluno);
            System.out.println("ALUNO ATUALIZADO.");
        } else {
            System.out.println("ALUNO NÃO ATUALIZADO.");
        }
    }

    private static void removerAluno() {
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        alunoService.removerAluno(cpf);
        System.out.println("ALUNO REMOVIDO.");
    }

    private static void listarAlunos() {
        List<Aluno> alunos = alunoService.listarAlunos();
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
}
