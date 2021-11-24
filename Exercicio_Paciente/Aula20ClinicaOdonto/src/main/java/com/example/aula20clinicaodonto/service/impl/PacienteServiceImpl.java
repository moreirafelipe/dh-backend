package com.example.clinica_odonto.service.impl;

import com.example.aula20clinicaodonto.model.Paciente;
import com.example.aula20clinicaodonto.model.Endereco;
import com.example.aula20clinicaodonto.service.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class PacienteServiceImpl implements OdontoService<Paciente> {
    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();
    private static Integer idGlobal = 1;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Override
    public Paciente salvar(Paciente paciente) {
        paciente.setIdEndereco(enderecoService.salvar(paciente.getEndereco()).getId());
        paciente.setId(idGlobal);
        pacienteMap.put(idGlobal, paciente);
        idGlobal++;
        return paciente;
    }

    @Override
    public Map<Integer, Paciente> buscarTodos() {
        return pacienteMap;
    }

    @Override
    public void deletar(Integer id) {
        pacienteMap.remove(id);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Paciente paciente = pacienteMap.get(id);
        paciente.setEndereco(enderecoService.buscarPorId(paciente.getIdEndereco()));

        /*Integer idEndereco = paciente.getIdEndereco();
        Endereco endereco = enderecoService.buscarPorId(idEndereco);
        paciente.setEndereco(endereco);*/

        return paciente;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        /*Paciente paciente = buscarPorId(id);
        paciente.setNome(nome);*/

        return paciente;
    }

}
