package com.example.aula23grestclinicaodonto.repository;

public interface IRepository<T> {
    T salvar(T t);
    T buscarPorId(Integer id);
}
