package codigoFinal;

import java.util.List;

import com.academia.Aluno;

public class AlunoService {
    private DAO<Aluno> alunoDAO = ConectorDAO.getInstancia().criarAlunoDAO();

    public void adicionarAluno(Aluno aluno) {
        if (CPFValidatorUtil.validarCPF(aluno.getCpf())) {
            alunoDAO.adicionar(aluno);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public Aluno buscarAluno(String cpf) {
        return alunoDAO.buscar(cpf);
    }

    public void atualizarAluno(Aluno aluno) {
        if (CPFValidatorUtil.validarCPF(aluno.getCpf())) {
            alunoDAO.atualizar(aluno);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public void removerAluno(String cpf) {
        alunoDAO.remover(cpf);
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listar();
    }
}
