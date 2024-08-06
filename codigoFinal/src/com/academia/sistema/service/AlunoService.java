package com.academia.sistema.service;

import java.util.List;
import com.academia.sistema.model.Aluno;
import com.academia.sistema.dao.DAO;
import com.academia.sistema.dao.ConectorDAO;
import com.academia.sistema.util.CPFValidatorController;

public class AlunoService {
    private DAO<Aluno> alunoDAO = ConectorDAO.getInstancia().criarAlunoDAO();
    private CPFValidatorController cpfValidator = CPFValidatorController.getInstancia();

    public void adicionarAluno(Aluno aluno) {
        if (cpfValidator.validarCPF(aluno.getCpf())) {
            alunoDAO.adicionar(aluno);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public Aluno buscarAluno(String cpf) {
        if (cpfValidator.validarCPF(cpf)) {
            return alunoDAO.buscar(cpf);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public void atualizarAluno(Aluno aluno) {
        if (cpfValidator.validarCPF(aluno.getCpf())) {
            alunoDAO.atualizar(aluno);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public void removerAluno(String cpf) {
        if (cpfValidator.validarCPF(cpf)) {
            alunoDAO.remover(cpf);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listar();
    }
}
