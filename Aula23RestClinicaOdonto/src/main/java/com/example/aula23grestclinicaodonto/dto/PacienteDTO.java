package com.example.aula23grestclinicaodonto.dto;

import com.example.aula23grestclinicaodonto.model.Endereco;
import com.example.aula23grestclinicaodonto.model.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer idEndereco;

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.idEndereco = paciente.getEndereco().getId();
    }
}
