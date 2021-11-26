package com.example.clinica_odontologica_2.model;

import com.example.clinica_odontologica_2.dto.ConsultaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Consulta {
    private Integer id;
    private Integer paciente;
    private Integer dentista;
    private Date dataHora;

    public Consulta() {}

    public Consulta(ConsultaDTO consultaDTO) {
        this.id = consultaDTO.getId();
        this.paciente = consultaDTO.getIdPaciente();
        this.dentista = consultaDTO.getIdPentista();
        this.dataHora = consultaDTO.getDataHora();
    }
}
