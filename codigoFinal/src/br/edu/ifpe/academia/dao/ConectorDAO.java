package br.edu.ifpe.academia.dao;

import br.edu.ifpe.academia.model.Aluno;

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
        return new GenericDAO<>();
    }
}
