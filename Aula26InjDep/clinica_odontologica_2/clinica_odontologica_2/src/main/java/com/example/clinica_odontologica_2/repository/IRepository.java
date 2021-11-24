package com.example.clinica_odontologica_2.repository;

import java.util.Map;

public interface IRepository<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
    Map<Integer, T> buscarTodos();
    void deletar(Integer id);
    T atualizar(Integer id, T t);
}
