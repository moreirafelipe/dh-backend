package com.example.base.persistence.entities;

import com.example.base.model.PacienteModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class PacienteEntity {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "pacientes_sequence", sequenceName = "pacientes_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacientes_sequence")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    public PacienteEntity() {
    }

    public PacienteEntity(PacienteModel paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = new EnderecoEntity(paciente.getEndereco());
    }
}
