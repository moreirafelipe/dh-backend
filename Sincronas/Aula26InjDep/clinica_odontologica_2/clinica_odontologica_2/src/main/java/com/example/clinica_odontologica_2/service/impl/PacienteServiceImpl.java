package com.example.clinica_odontologica_2.service.impl;

import com.example.clinica_odontologica_2.model.Paciente;
import com.example.clinica_odontologica_2.repository.impl.PacienteRepositoryImpl;
import com.example.clinica_odontologica_2.service.OdontoService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {
    private PacienteRepositoryImpl pacienteRepository;

    public PacienteServiceImpl() {
        this.pacienteRepository = new PacienteRepositoryImpl();
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteRepository.buscarPorId(id);
    }

    @Override
    public void deletar(Integer id) {}

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return null;
    }

    @Override
    public Paciente atualizar(Integer id, Paciente paciente) {
        return null;
    }
}
