package codigoFinal;

import java.util.List;

public interface DAO<T> {

    void adicionar(T t);
    T buscar(String id);
    void atualizar(T t);
    void remover(String id);
    List<T> listar();
    
}
