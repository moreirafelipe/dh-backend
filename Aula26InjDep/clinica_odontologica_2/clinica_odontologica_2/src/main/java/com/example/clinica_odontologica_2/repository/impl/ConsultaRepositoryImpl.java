package com.example.clinica_odontologica_2.repository.impl;

import com.example.clinica_odontologica_2.dto.ConsultaDTO;
import com.example.clinica_odontologica_2.dto.PacienteDTO;
import com.example.clinica_odontologica_2.model.Consulta;
import com.example.clinica_odontologica_2.model.Dentista;
import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ConsultaRepositoryImpl implements IRepository<Consulta> {
    private static Map<Integer, ConsultaDTO> consultaDTOMap = new HashMap<>();
    private static Integer idGlobal = 1;

    private DentistaRepositoryImpl dentistaRepository;
    private PacienteRepositoryImpl pacienteRepository;
    private EnderecoRepositoryImpl enderecoRepository;

    public ConsultaRepositoryImpl(){
        this.dentistaRepository = new DentistaRepositoryImpl();
        this.pacienteRepository = new PacienteRepositoryImpl();
        this.enderecoRepository = new EnderecoRepositoryImpl();
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
    public Map<Integer, Consulta> buscarTodos() {

        Map<Integer, Consulta> consultaQuery = new HashMap<>();

        consultaDTOMap.entrySet()
                .stream()
                .forEach( consulta -> consultaQuery.put(consulta.getValue().getId(),

                        new Consulta(consulta.getValue(),
                                pacienteRepository.buscarPorId(consulta.getValue().getId()),
                                dentistaRepository.buscarPorId(consulta.getValue().getIdDentista()))));

        return consultaQuery;
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);
        Paciente paciente = pacienteRepository.buscarPorId(consultaDTO.getIdPaciente());
        Dentista dentista = dentistaRepository.buscarPorId(consultaDTO.getIdDentista());
        Consulta consulta = new Consulta(consultaDTO, paciente, dentista);
        return consulta;
    }

    @Override
    public Consulta atualizar(Integer id, Consulta consulta) {

        Consulta consultaQuery = consulta;
        ConsultaDTO consultaDTO = consultaDTOMap.get(id);

        if(consultaDTO == null)
            return null;
        consultaQuery.setId(id);

        Paciente paciente = pacienteRepository.buscarPorId(consultaDTO.getIdPaciente());
        pacienteRepository.atualizar(paciente.getId(), consulta.getPaciente());

        Dentista dentista = dentistaRepository.buscarPorId(consultaDTO.getIdDentista());
        dentistaRepository.atualizar(dentista.getId(), consulta.getDentista());

        consultaDTOMap.put(id, new ConsultaDTO(consulta));

        return consultaQuery;
    }

    @Override
    public void deletar(Integer id) {
        consultaDTOMap.remove(id);
    }
}
