package com.example.checkpoint_clinica.controller;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="professores")
public class DentistaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

    @Column(name="especialidade")
    private String especialidade;

    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    private Set<PacienteEntity> pacientes = new HashSet<>();

}
