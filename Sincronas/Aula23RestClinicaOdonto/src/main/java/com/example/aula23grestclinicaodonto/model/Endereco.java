package com.example.aula23grestclinicaodonto.model;

import com.example.aula23grestclinicaodonto.dto.EnderecoDTO;
import lombok.Getter;
import lombok.Setter;


//USando metodo contrutor vazio padrao
@Getter
@Setter
public class Endereco {
    private Integer id;
    private String rua;
    private String numero;

    public Endereco(){};

    public Endereco(EnderecoDTO enderecoDTO) {
        this.id = enderecoDTO.getId();
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
    }
}
