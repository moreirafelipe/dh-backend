package com.example.base.services.impl;

import com.example.base.dto.PacienteDTO;
import com.example.base.exceptions.ResourceNotFoundException;
import com.example.base.model.PacienteModel;
import com.example.base.persistence.entities.PacienteEntity;
import com.example.base.persistence.repository.PacienteRepository;
import com.example.base.services.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements OdontoService<PacienteModel> {

    private final PacienteRepository pacienteRepository;
    private final EnderecoServiceImpl enderecoService;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, EnderecoServiceImpl enderecoService) {
        this.pacienteRepository = pacienteRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public PacienteModel salvar(PacienteModel paciente) {
        paciente.setEndereco(enderecoService.salvar(paciente.getEndereco()));
        PacienteEntity pacienteEntity = new PacienteEntity(paciente);
        return new PacienteModel(pacienteRepository.save(pacienteEntity));
    }

    public PacienteModel buscarPorId(Integer id) throws ResourceNotFoundException {
        try {
            return new PacienteModel(pacienteRepository.getById(id));
        } catch(Exception e) {
            throw new ResourceNotFoundException("Não existe paciente com o id: " + id);
        }
    }

    public PacienteDTO buscarPorIdDTO(Integer id) throws ResourceNotFoundException {
        try {
            return new PacienteDTO(pacienteRepository.getById(id));
        } catch(Exception e) {
            throw new ResourceNotFoundException("Não existe paciente com o id: " + id);
        }
    }

    public void deletar(Integer id) throws ResourceNotFoundException {
        try {
            pacienteRepository.deleteById(id);;
        } catch(Exception e) {
            throw new ResourceNotFoundException("Não existe paciente com o id " + id + " para ser deletado.");
        }
    }
}
