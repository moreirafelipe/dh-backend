package com.example.base.dto;

import com.example.base.persistence.entities.EnderecoEntity;
import com.example.base.persistence.entities.PacienteEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    public PacienteDTO() {
    }

    public PacienteDTO(PacienteEntity paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.rua = paciente.getEndereco().getRua();
        this.numero = paciente.getEndereco().getNumero();
        this.cidade = paciente.getEndereco().getCidade();
        this.estado = paciente.getEndereco().getEstado();
    }
}
