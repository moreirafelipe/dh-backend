package com.example.aula23filme.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmeDTO {
    private String nome;
    private String categoria;
    private String id;

    public FilmeDTO(String nome, String categoria, String id) {
        this.nome = nome;
        this.categoria = categoria;
        this.id = id;
    }
}
