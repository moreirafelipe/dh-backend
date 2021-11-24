package com.example.clinica.service;

import com.example.clinica.model.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> buscarTodos();
    Paciente buscarPorEmail (String email);
}
