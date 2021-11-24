package com.example.clinica_odontologica_2.repository.impl;

import com.example.clinica_odontologica_2.dto.ConsultaDTO;
import com.example.clinica_odontologica_2.dto.PacienteDTO;
import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.repository.IRepository;

import java.util.HashMap;
import java.util.Map;

public class ConsultaRepositoryImpl implements IRepository<Consulta> {
    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;

    public ConsultaRepositoryImpl(){
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        Paciente paciente = pacienteRepository.buscarPorId(consulta.getPaciente().getId());
        if(paciente == null)
            return null;

        Dentista dentista = dentistaRepository.buscarPorId(consulta.getDentista().getId());
        if(dentista == null)
            return null;

        consulta.setId(idGlobal);
        consulta.setPaciente(paciente);
        consulta.setDentista(dentista);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        consultaDTOMap.put(idGlobal, consultaDTO);
        idGlobal++;
        return consulta;
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        Paciente paciente = pacienteRepository.buscarPorId(consultaDTO.getIdPaciente());
        Dentista dentista = dentistaRepository.buscarPorId(consultaDTO.getIdDentista());
        Consulta consulta = new Consulta(consultaDTO, paciente, dentista);
        return consulta;
    }
}
