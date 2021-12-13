package com.example.base.model;

import com.example.base.persistence.entities.EnderecoEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModel {
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;

    public EnderecoModel(){};

    public EnderecoModel(EnderecoEntity endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
}
