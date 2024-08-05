package com.academia.sistema.dao;

import com.academia.Aluno;
import com.academia.sistema.dao.DAO;

public class ConectorDAO {

    private static ConectorDAO instancia;

    private ConectorDAO() {}

    public static synchronized ConectorDAO getInstancia() {
        if (instancia == null) {
            instancia = new ConectorDAO();
        }
        return instancia;
    }

    public DAO<Aluno> criarAlunoDAO() {
        //return new AlunoDAO();
    }
}
