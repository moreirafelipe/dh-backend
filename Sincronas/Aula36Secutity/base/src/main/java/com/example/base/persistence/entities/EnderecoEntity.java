package com.example.base.persistence.entities;

import com.example.base.model.EnderecoModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class EnderecoEntity {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "enderecos_sequence", sequenceName = "enderecos_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enderecos_sequence")
    private Integer id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    public EnderecoEntity(){};

    public EnderecoEntity(EnderecoModel endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }
}
