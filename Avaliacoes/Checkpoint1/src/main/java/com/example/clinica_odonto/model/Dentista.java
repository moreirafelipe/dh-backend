package com.example.clinica_odonto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private String especialidade;
    private Endereco endereco;
    private Integer idEndereco;
}
