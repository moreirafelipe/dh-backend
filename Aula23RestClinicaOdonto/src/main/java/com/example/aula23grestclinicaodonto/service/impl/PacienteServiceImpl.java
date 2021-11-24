package com.example.aula23grestclinicaodonto.service.impl;

import com.example.aula23grestclinicaodonto.model.Paciente;
import com.example.aula23grestclinicaodonto.repository.impl.PacienteRepositoryImpl;
import com.example.aula23grestclinicaodonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {

    @Autowired
    private PacienteRepositoryImpl pacienteRepository;

    @Override
    public Paciente salver(Paciente paciente) {
        return pacienteRepository.salvar(paciente);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteRepository.buscarPorId(id);
    }
}
