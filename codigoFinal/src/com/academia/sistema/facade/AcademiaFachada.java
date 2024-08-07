package com.academia.sistema.facade;


import com.academia.sistema.model.Aluno;

import com.academia.sistema.service.AlunoService;
import com.academia.sistema.decorator.DescontoAcademico;
import com.academia.sistema.decorator.DescontoFamiliar;
import com.academia.sistema.decorator.DescontoParceira;
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

   
   public double aplicarDescontoAcademico(String cpf) {
        Aluno aluno = alunoService.buscarAluno(cpf);
        if (aluno == null) {
        	throw new RuntimeException("");

        }
        DescontoAcademico desconto = new DescontoAcademico(aluno);
        return desconto.getValor();
        
            }

   public double aplicarDescontoFamiliar(String cpf) {
       Aluno aluno = alunoService.buscarAluno(cpf);
       if (aluno == null) {
       	throw new RuntimeException("");

       }
       DescontoFamiliar desconto = new DescontoFamiliar(aluno);
       return desconto.getValor();
       
           }


   
   public double aplicarDescontoParceria(String cpf) {
       Aluno aluno = alunoService.buscarAluno(cpf);
       if (aluno == null) {
          	throw new RuntimeException("");
       }
            DescontoParceira desconto = new DescontoParceira(aluno);
            return desconto.getValor();
        
    }
}
