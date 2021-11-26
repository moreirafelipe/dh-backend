package com.example.aula20clinicaodonto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paciente {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idede;
    private Endereco endereco;
    private Integer idEndereco;
}
