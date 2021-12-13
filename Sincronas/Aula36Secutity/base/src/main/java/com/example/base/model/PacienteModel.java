package com.example.base.model;

import com.example.base.persistence.entities.PacienteEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteModel {
    private Integer id;
    private String nome;
    private String sobrenome;
    private EnderecoModel endereco;

    public PacienteModel(){};

    public PacienteModel(PacienteEntity paciente){
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = new EnderecoModel(paciente.getEndereco());
    }
}
