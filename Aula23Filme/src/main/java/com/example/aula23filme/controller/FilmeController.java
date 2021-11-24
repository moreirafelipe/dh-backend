package com.example.aula23filme.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmeController {
    private String nome;
    private String categoria;
    private Integer premios;
    private Integer id;

    public FilmeController(String nome, String categoria, Integer premios, Integer id) {
        this.nome = nome;
        this.categoria = categoria;
        this.premios = premios;
        this.id = id;
    }
}
