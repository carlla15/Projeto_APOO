package br.edu.ifpe.academia.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpe.academia.model.ClasseBase;

public class GenericDAO<T extends ClasseBase> implements DAO<T> {
    private List<T> lista = new ArrayList<>();

    @Override
    public void adicionar(T t) {
        lista.add(t);
    }

    @Override
    public T buscar(String id) {
        for (T t : lista) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
    @Override
    public void atualizar(T t) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(t.getId())) {
                lista.set(i, t);
                return;
            }
        }
    }
    @Override
    public void remover(String id) {
        lista.removeIf(t -> t.getId().equals(id));
    }

    @Override
    public List<T> listar() {
        return new ArrayList<>(lista);
    }
}