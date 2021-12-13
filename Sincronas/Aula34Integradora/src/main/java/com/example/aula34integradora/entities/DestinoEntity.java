package com.example.aula34integradora.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "pacotes")
public class DestinoEntity {

    private String endereco;
    private Integer numero;
    private String cidade;
    private String estado;
}
