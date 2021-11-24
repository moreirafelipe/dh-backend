package com.example.aula20clinicaodonto.service;

import com.example.aula20clinicaodonto.model.Paciente;

import java.util.Map;

public interface OdontoService<T> {
    T salvar(T t);
    Map<Integer, T> buscarTodos();
    Paciente buscarPorId(Integer id);
    Paciente atualizarPaciente(Integer id, String nome);
    void deletar(Integer id);
}
