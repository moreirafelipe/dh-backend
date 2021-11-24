package com.example.aula23grestclinicaodonto.service;

public interface OdontoService<T> {
    T salver(T t);
    T buscarPorId(Integer id);
}
